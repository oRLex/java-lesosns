package app.dto;

import app.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class ReMapper {

  public Person1 personToPerson1(Person p) {
    return new Person1(
      p.getName(),
      p.getExtra()
    );
  }

  public Person2 personToPerson2(Person p) {
    return new Person2(
      p.getName(),
      p.getPhones()
    );
  }

}
