package lesson06;

public class Person {
  final int id;
  final int age;
  final String name;

  private static int x;
  final static String header = "Authorization";

  public Person(int age, String name) {
    this.id = ++x;
    this.age = age;
    this.name = name;
  }

  public Person incAge() {
    return new Person(age + 1, name);
  }

  public static int x() {
    return x;
  }

  public static int add(int a, int b) {
    return a + b + x;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (obj.getClass() != this.getClass()) return false;
    Person that = (Person) obj;

    return this.age == that.age
        && this.name != null
        && this.name.equals(that.name);
  }

  static void printMe() {
    int my_x = x;
    System.out.println("PERSON");
  }

}
