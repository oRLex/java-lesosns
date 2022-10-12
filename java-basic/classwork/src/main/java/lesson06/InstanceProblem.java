package lesson06;

public class InstanceProblem {

  static class Animal {}
  static class Cat extends Animal {
    String name;
  }
  static class Dog extends Animal {}

  public static void main(String[] args) {
    Cat cat = new Cat();
    Dog dog = new Dog();
    Animal animal = new Animal();

    animal.equals(cat);
    System.out.println(cat instanceof Animal);


  }
}
