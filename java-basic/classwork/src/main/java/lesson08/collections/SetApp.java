package lesson08.collections;

import java.util.HashSet;

public class SetApp {
  public static void main(String[] args) {
    HashSet<Integer> set = new HashSet<Integer>();

    set.add(1);
    set.add(1);
    set.add(2);
    System.out.println(set.size());
    System.out.println(set);
    set.forEach(x -> System.out.println(x));
    set.forEach(System.out::println);
  }
}
