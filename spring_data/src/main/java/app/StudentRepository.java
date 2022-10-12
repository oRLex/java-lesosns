package app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
//  @Query(value = "", nativeQuery = true)
//  List<Student> findAllByNameContainsIgnoreCaseOrIdIsGreaterThan(String part, Integer id);
}
