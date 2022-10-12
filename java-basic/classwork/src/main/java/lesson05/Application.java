package lesson05;

public class Application {

  public static void doSomething(Student s) {
    System.out.println(s.age);
    System.out.println(s.name);
    System.out.println(s.group);
    String house = s.house;
    Street street = s.street;
  }

  public static void main(String[] args) {
    int student_age = 33;
    String student_name = "Jim";
    String student_group = "FS13";

//    Student s1 = new Student(44, "Jerry", Optional.of("FS13"));
//    Student s2 = new Student(44, "Jerry", Optional.empty());
    Student s1a = new Student(44, "Jerry", "FS13");
    Student s2a = new Student(44, "Jerry");
//    int age = s.age;
//    s.age = 44;
//    s.name = "Jerry";
//    s.group = Optional.of("FS13");

    doSomething(s2a);
  }

}
