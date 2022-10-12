package app.service;

import app.entity.Person;
import app.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepo repo;

  public List<Person> getAll() {
    return repo.findAll();
  }

  public Optional<Person> getOneById(Long id) {
    return repo.findById(id);
  }

  public List<Person> getAllPageable(int pageNumber, int pageSize) {
    return repo.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
  }
}
