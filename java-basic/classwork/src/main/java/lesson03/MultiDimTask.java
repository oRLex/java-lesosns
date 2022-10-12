package lesson03;

import java.util.StringJoiner;
import java.util.function.Predicate;

import static lesson03.Task1FillAndSeparateEvenAndOdd.randomRange;

public class MultiDimTask {

  public static String arrayToString(int[] a) {
    StringBuilder sb = new StringBuilder();

    boolean isFirst = true;
    for (int x: a) {
      if (isFirst) {
        isFirst = false;
      } else {
        sb.append(", ");
      }
      sb.append(x);
    }
    return sb.toString();
  }

  public static String arrayToString2(int[] a) {
    StringJoiner sj = new StringJoiner(", ");
    for (int x: a) {
      sj.add(String.format("%2d", x));
    }
    return sj.toString();
  }

  public static String arrayToStringWithFilter(int[] a, Predicate<Integer> predicate) {
    StringJoiner sj = new StringJoiner(", ");
    for (int x: a) {
      sj.add(predicate.test(x) ? String.format("%2d", x) : "  ");
    }
    return sj.toString();
  }

  public static void main(String[] args) {
    int ROWS = 5;
    int COLS = 10;
    int[][] a = new int[ROWS][COLS];
    for (int y = 0; y < ROWS; y++) {
      for (int x = 0; x < COLS; x++) {
        a[y][x] = randomRange(1,20);
      }
    }

    for (int i = 0; i < ROWS; i++) {
      System.out.println(arrayToStringWithFilter(a[i], x -> x % 2 == 0));
    }

  }
}

/**
 * 14,   , 12, 10, 18,   , 14,   ,   , 18
 *   ,   ,   , 18, 14, 18,   ,   , 18,
 * 10, 12,   , 10, 10, 18,   ,   ,   , 16
 *   , 10,   , 20, 16, 16, 12,   , 20, 10
 * 18,   ,   ,   , 20, 14, 20, 14,   ,
 */
