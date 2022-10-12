package lesson06;

public class PersonApp {

  public static void main(String[] args) {
    Person.printMe();
    Person p1 = new Person(1, "Alex");
    Person p2 = new Person(1, "Alex");
    Person p3 = new Person(1, "Alex");
    Person p4 = new Person(1, "Alex");
    System.out.println(p1 == p2); //
    System.out.println(p1.equals(p2));
    System.out.println(Person.x());
    System.out.println(p2.x());
  }
}
