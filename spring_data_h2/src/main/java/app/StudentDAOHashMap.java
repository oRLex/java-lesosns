package app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class StudentDAOHashMap implements CrudRepository<Student, Integer> {

  private final Map<Student, Integer> storage = new HashMap<>();

  @Override
  public <S extends Student> S save(S s) {
    return null;
  }

  @Override
  public <S extends Student> Iterable<S> saveAll(Iterable<S> iterable) {
    return null;
  }

  @Override
  public Optional<Student> findById(Integer integer) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Integer integer) {
    return false;
  }

  @Override
  public Iterable<Student> findAll() {
    return null;
  }

  @Override
  public Iterable<Student> findAllById(Iterable<Integer> iterable) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Integer integer) {

  }

  @Override
  public void delete(Student student) {

  }

  @Override
  public void deleteAll(Iterable<? extends Student> iterable) {

  }

  @Override
  public void deleteAll() {

  }
}
