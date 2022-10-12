package app;

import io.vavr.Tuple2;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AppController {

  private final StudentService studentService;

  /**
   * http://localhost:8080/2
   */
  @GetMapping("/2")
  public Stream<Student> allStream() {
    return studentService.getAllbyIds();
  }

  @PostMapping
  public void create(@RequestBody Student student) {
    studentService.create(student);
  }

}
