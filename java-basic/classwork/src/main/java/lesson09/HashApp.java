package lesson09;

import java.util.HashSet;

public class HashApp {

  public static void main(String[] args) {

    HashSet<Integer> set1 = new HashSet<>();
    set1.add(1);
    set1.add(1);
    set1.add(2);
//    System.out.println(set1.size());

    HashSet<Person> set2 = new HashSet<>();
    Person p1 = new Person(1, "Jim");
    Person p2 = new Person(11, "Jim");
    set2.add(p1);
    set2.add(p2);
    System.out.println(set2.size());

  }
}
