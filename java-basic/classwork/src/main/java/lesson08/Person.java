package lesson08;

import java.util.Optional;

public class Person {
  final int id;
  final String name;
  final Optional<String> group;

  public Person(int id, String name, Optional<String> group) {
    this.id = id;
    this.name = name;
    this.group = group;
  }

  static Person of(int id, String name, String group) {
    return new Person(id, name, Optional.of(group));
  }

  static Person of(int id, String name) {
    return new Person(id, name, Optional.empty());
  }

}
