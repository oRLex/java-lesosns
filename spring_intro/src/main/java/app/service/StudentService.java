package app.service;

import app.dto.Student;
import app.exc.StudentNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  public Student get(int id) {
    if (id == 111) return new Student(111, "Alex");
    else throw new StudentNotFoundException(id);
  }

}
