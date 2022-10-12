package lesson09;

import java.util.ArrayList;

/**
 * 1. generate 100 random numbers in range 0..100
 * 2. put them into ArrayList
 * 3. put odd ones into second ArrayList
 * 4. put even numbers into third ArrayList
 */
public class Task1B {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      numbers.add((int) (Math.random() * 100));
    }
    ArrayList<Integer> odd = new ArrayList<>(numbers);
    ArrayList<Integer> even = new ArrayList<>(numbers);

    odd.removeIf(x -> x % 2 == 0);
    even.removeIf(x -> x % 2 != 0);

    System.out.println(numbers);
    System.out.println(odd);
    System.out.println(even);

  }
}
