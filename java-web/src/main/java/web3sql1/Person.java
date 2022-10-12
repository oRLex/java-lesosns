package web3sql1;

import java.util.Optional;

public class Person {
  Integer id;
  String name;
  Optional<Integer> group;

  public Person(Integer id, String name, Integer group) {
    this.id = id;
    this.name = name;
    this.group = Optional.ofNullable(group);
  }

  @Override
  public String toString() {
    return String.format("Person{id=%d, name='%s', group=%s}", id, name, group);
  }
}
