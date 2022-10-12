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
  private final AccountService accountService;
  /**
   * http://localhost:8080/
   */
  @GetMapping
  public Iterable<Student> all() {
    return studentService.getAll();
  }

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

  @Transactional
  public void doTransfer() {
    Optional<Tuple2<Account, Account>> result =
      accountService.transfer(new Account(), new Account(), 1000);
    result.ifPresent(t2 -> {
      Account newAccount1 = t2._1();
      Account newAccount2 = t2._2();
      //...
    });
  }
}
