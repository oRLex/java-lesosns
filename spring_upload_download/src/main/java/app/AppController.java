package app;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/person")
public class AppController {

  private final PersonService service;

  /**
   * http://localhost:8080/person
   * http://localhost:8080/person?limit=5
   */
  @GetMapping
  public Collection<Person> people(@RequestParam Optional<Integer> limit) {
    log.info(limit);
    return service.getAll();
  }

  /**
   * http://localhost:8080/person/1
   * http://localhost:8080/person/2
   * http://localhost:8080/person/3
   */
  @GetMapping("{id}")
  public ResponseEntity<?> person(@PathVariable Integer id) {
    Optional<Person> x = service.getOne(id);
    if (!x.isPresent()) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(x.get());
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public void create(@RequestBody Person p) {
    p.setId(null);
    service.add(p);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody Person p) {
    boolean x = service.update(p);
    if (x) return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    boolean x = service.remove(id);
    if (x) return ResponseEntity.status(HttpStatus.OK).build();
    else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/die")
  public void doSomething() {
    service.die();
  }

  @GetMapping("/cookie")
  public void readCookie(@CookieValue(value = "XID", defaultValue = "F19") String xid) {
    log.info(xid);
  }

}
