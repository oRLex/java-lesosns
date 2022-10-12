package lesson12.dao;

public class Student extends Identifiable {
  final String name;

  public Student(int id, String name) {
    super(id);
    this.name = name;
  }
}
