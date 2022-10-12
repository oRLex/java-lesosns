package app.controller;

import app.dto.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class AppController {

  @GetMapping("/")
  public String servlet1() {
    return "Hello World!";
  }

  @GetMapping("/s")
  public Student servlet2a() {
    return new Student(11, "Jim");
  }

  @PostMapping("/s")
  public String servlet2b() {
    return "Hello World!";
  }

}
