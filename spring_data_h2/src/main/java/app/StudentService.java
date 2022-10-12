package app;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Log4j2
public class StudentService {

  private final StudentRepository studentRepository;

  public void create(Student student) {
    student.setId(null);
    studentRepository.save(student);
  }

  public Stream<Student> getAllbyIds() {
    Iterable<Integer> ids = Arrays.asList(1, 2, 3);
    Iterable<Student> students = studentRepository.findAllById(ids);
    return StreamSupport.stream(students.spliterator(), false);
  }
}
