package app.service;

import app.entity.Person;
import app.entity.Phone;
import app.repo.PersonRepo;
import app.repo.PhoneRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {

  private final PhoneRepo repo;

  public List<Phone> getAll() {
    return repo.findAll();
  }

}
