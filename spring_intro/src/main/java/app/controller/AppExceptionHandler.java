package app.controller;

import app.exc.StudentNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AppExceptionHandler {

  @ExceptionHandler({StudentNotFoundException.class})
  @ResponseBody
  public String handle(StudentNotFoundException x) {
    return String.format("requested user %d not found", x.student_id);
  }

}
