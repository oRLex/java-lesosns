package app.controller;

import app.entity.Person;
import app.entity.Phone;
import app.service.PersonService;
import app.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("phone")
@RequiredArgsConstructor
public class PhoneController {

  private final PhoneService service;

  @GetMapping
  public List<Phone> getAll() {
    return service.getAll();
  }

}
