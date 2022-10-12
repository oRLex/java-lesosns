package app;

import app.dbconn.Connection1;
import app.dbconn.Connection2;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Log4j2
public class StudentService {

  private final StudentRepository studentRepository;
//  private final StudentDAOHashMap studentRepository;
  private final Connection1 conn1;
  private final Connection2 conn2;

  public Iterable<Student> getAll() {
    log.info(conn1);
    log.info(conn2);
    return studentRepository.findAll();
  }

//  public void create(RqStudentToCreate student) {
//    student.setId(null);
//    studentRepository.save(student);
//  }

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
