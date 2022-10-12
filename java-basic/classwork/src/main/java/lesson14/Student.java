package lesson14;

import java.io.Serializable;

public class Student implements Serializable {

  static final long serialVersionUID = 1L;

  int id;
  String name;
  String group;

  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Student(int id, String name, String group) {
    this.id = id;
    this.name = name;
    this.group = group;
  }

  @Override
  public String toString() {
    return String.format("Student{id=%d, name='%s', group=%s}", id, name, group);
  }

  public String toString2() {
    return String.format("[id=%d, name='%s']", id, name);
  }
}
