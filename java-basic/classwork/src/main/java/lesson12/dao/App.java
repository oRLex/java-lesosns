package lesson12.dao;

import java.util.HashMap;
import java.util.Map;

public class App {

  public static Map<Integer, Student> doSmth2(Map<Integer, Student> db, Student s) {
    db.put(s.id, s);
    return db;
  }

  public static void doSmth(Map<Integer, Student> db) {
    Student s1 = db.get(1);
    Student s2 = db.get(2);
    Student s3 = db.get(3); // null
  }

  public static void main(String[] args) {
    HashMap<Integer, Student> db = new HashMap<>();

    Student s1 = new Student(111, "Jim");
    Student s2 = new Student(2, "Bob");

    db.put(s1.id, s1);
    db.put(s2.id, s2);
    doSmth(db);

  }
}
