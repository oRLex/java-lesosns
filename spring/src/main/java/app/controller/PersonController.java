package app.controller;

import app.dto.Person1;
import app.dto.Person1Mapper;
import app.dto.Person2;
import app.dto.ReMapper;
import app.entity.Person;
import app.service.PersonService;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

  private final PersonService service;
  private final ReMapper m;
  private final ObjectMapper om;
  private final Person1Mapper pm1mapper;

  @GetMapping
  public List<Person> getAll() {
    return service.getAll();
  }

  @GetMapping("{id}")
  public Optional<Person> getOne(@PathVariable("id") Long id) {
    Optional<Person> p = service.getOneById(id);
    p.ifPresent(p0 -> System.out.println(p0));
    return p;
  }

  @JsonView({View.Admin.class})
  @GetMapping("f1/{id}")
  public Optional<Person> getOne1(@PathVariable("id") Long id) {
    Optional<Person> p = service.getOneById(id);
    p.ifPresent(p0 -> System.out.println(p0));
    return p;
  }

  @JsonView({View.Guest.class})
  @GetMapping("f2/{id}")
  public Optional<Person> getOne2(@PathVariable("id") Long id) {
    Optional<Person> p = service.getOneById(id);
    p.ifPresent(p0 -> System.out.println(p0));
    return p;
  }

  @GetMapping("g1/{id}")
  public Optional<Person1> getOne1a(@PathVariable("id") Long id) {
    Optional<Person> p = service.getOneById(id);
    p.ifPresent(p0 -> System.out.println(p0));
    return p.map(m::personToPerson1);
  }

  @GetMapping("g2/{id}")
  public Optional<Person2> getOne2a(@PathVariable("id") Long id) {
    Optional<Person> p = service.getOneById(id);
    p.ifPresent(p0 -> System.out.println(p0));
    return p.map(m::personToPerson2);
  }

  @GetMapping("h1/{id}")
  public Optional<Person1> getOne1b(@PathVariable("id") Long id) {
    Optional<Person> p = service.getOneById(id);
    p.ifPresent(p0 -> System.out.println(p0));
    return p.map(p0 -> om.convertValue(p0, Person1.class));
  }

  @GetMapping("h2/{id}")
  public Optional<Person2> getOne2b(@PathVariable("id") Long id) {
    Optional<Person> p = service.getOneById(id);
    p.ifPresent(p0 -> System.out.println(p0));
    return p.map(p0 -> om.convertValue(p0, Person2.class));
  }

//  @GetMapping("om1/{id}")
//  public Optional<Person1> getOne1c(@PathVariable("id") Long id) {
//    Optional<Person> p = service.getOneById(id);
//    p.ifPresent(p0 -> System.out.println(p0));
//    return p.map(pm1mapper::convert);
//  }

}
