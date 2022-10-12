package lesson03;

import java.util.Random;

/**
 * 1. create an array with length=10
 * 2. fill it wit random values in range [1, 10]
 * 3. filter and print only even numbers
 */
public class Task1FillAndPrintEvens {
  public static void main(String[] args) {
    Random r = new Random(84756);
    int nextRand = r.nextInt(10) + 1;
  }
}
