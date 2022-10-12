package lesson08;

import java.util.Optional;

public class PersonApp {
  public static void main(String[] args) {
    Person p1 = new Person(1, "Jim", Optional.of("FS13"));
    Person p2 = new Person(1, "Jim", Optional.empty());

    Person p3 = Person.of(1, "Jim", "FS13");
    Person p4 = Person.of(1, "Jim");
  }
}
