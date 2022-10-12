package lesson12.dao;

import java.util.Optional;
import java.util.Set;

public class AppDao1 {
  public static void main(String[] args) {
    DAO<Student> db = new DaoHashMap<>();
    DAO<Book> db2 = new DaoHashMap<>();

    Student s1 = new Student(33, "Jeremy");
    Student s3 = new Student(33, "JEREMY");
    db.create(s1);
    Optional<Student> got = db.get(33);
    db.delete(s1.id);
    db.delete(s1);
    db.update(s3);
    Set<Student> students = db.getAll();
  }
}
