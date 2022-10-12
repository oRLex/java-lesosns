package lesson09;

import java.util.ArrayList;

/**
 * 1. generate 100 random numbers in range 0..100
 * 2. put them into ArrayList
 * 3. put odd ones into second ArrayList
 * 4. put even numbers into third ArrayList
 */
public class Task1A {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<Integer> odd = new ArrayList<>();
    ArrayList<Integer> even = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      numbers.add((int) (Math.random() * 100));
    }

    for (int x: numbers) {
      if      (x % 2 == 0) even.add(x);
      else if (x % 2 != 0) odd.add(x);
    }

    System.out.println(numbers);
    System.out.println(odd);
    System.out.println(even);

  }
}
