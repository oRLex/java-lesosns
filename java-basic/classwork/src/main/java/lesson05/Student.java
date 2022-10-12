package lesson05;

import java.util.Optional;

public class Student {

  final int age;
  final String name;
  final Optional<String> group;

  Street street;
  String house;

  public Student(int age, String name) {
    this(age, name, Optional.empty());
  }

  public Student(int age, String name, String group) {
    this(age, name, Optional.of(group));
  }

  private Student(int age, String name, Optional<String> group) {
    this.age = age;
    this.name = name;
    this.group = group;
  }

  public int getAge() {
    return age;
  }

}
