package app.controller;

import app.dto.Student;
import app.exc.BusinessException;
import app.exc.DuplicateStudentException;
import app.exc.StudentNotFoundException;
import app.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.rmi.StubNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService ss;
  private final Map<Integer, Student> data = new HashMap<>();

  private Integer nextId = 0;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public Collection<Student> all() {
    return data.values();
  }

  @GetMapping("byname")
  public Collection<Student> findByName(@RequestParam("part") String part) {
    return data.values().stream().filter(s -> s.getName().contains(part)).collect(Collectors.toList());
  }


  @GetMapping("/v1/{id}")
  public Student one1(@PathVariable("id") Integer id) {
    return data.get(id);
  }

  /**
   * http://localhost:8081/student/v2/111
   * http://localhost:8081/student/v2/1
   */
  @GetMapping("/v2/{id}")
  public Student one11(@PathVariable("id") Integer id) {
    return ss.get(id);
  }

  @GetMapping("{id}")
  public ResponseEntity<Student> one2(@PathVariable("id") Integer id) {
    Student got = data.get(id);
    return got == null ?
      ResponseEntity.noContent().build() :
      ResponseEntity.ok(got);
  }


  @DeleteMapping("{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    Student was = data.remove(id);
    return was == null ?
      ResponseEntity.notFound().build() :
      ResponseEntity.ok().build();
  }

  @SneakyThrows
  @PostMapping
  public ResponseEntity<Student> createOne(@RequestBody Student student) {
    student.setId(null);
    student.setId(++nextId);
    data.put(student.getId(), student);
    return ResponseEntity.created(new URI("/student/"+student.getId().toString()))
      .body(data.get(student.getId()));
//    return ResponseEntity.status(HttpStatus.CREATED)
//      .header("X-CREARED-ID", student.getId().toString())
//      .body(data.get(student.getId()));
//    ResponseEntity.status(HttpStatus.CONFLICT);
  }

  @PutMapping("{id}")
  public ResponseEntity<Student> updateOne(@PathVariable("id") Integer id, @RequestBody Student student) {
    Student got = data.get(id);
    if (got == null) return ResponseEntity.notFound().build();
    student.setId(id);
    data.put(id, student);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(data.get(id));
  }

//  @ExceptionHandler({StudentNotFoundException.class})
//  public ResponseEntity<Student> handle() {
//    return ResponseEntity.status(555).body(new Student(999, "Magic User"));
//  }

}
