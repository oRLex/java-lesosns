package a01sort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import static util.Util.NI;

public class SortApp {

  /**
   * sort in place
   * MUTABLE
   */
  public void sort1(int[] a) {
    throw NI;
  }

  /**
   * Immutable,
   * new structure will be returned
   */
  public int[] sort2(int[] a) {
    throw NI;
  }

  //  O(n^2)
  public static void bubbleSort(int[] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length; j++) {
        if (a[i] < a[j]) {
          int c = a[i];
          a[i] = a[j];
          a[j] = c;
        }
      }
    }
  }

  // O(n^2 / 2 - n)
  public static void bubbleSort2(int[] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = i+1; j < a.length; j++) {
        if (a[i] > a[j]) {
          int c = a[i];
          a[i] = a[j];
          a[j] = c;
        }
      }
    }
  }

  //  O(n^2 + n)
  public static void sort2() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; i < 5; i++) {

      }
    }

    for (int j = 0; j < 5; j++) {

    }
  }
  // O(n + n) = O(2 n)
  public static void sort3() {
    for (int j = 0; j < 5; j++) {

    }
    for (int j = 0; j < 5; j++) {

    }
  }


  public static void main(String[] args) {
    int[] data = new Random().ints(10, 10, 50)
      .toArray();
    System.out.println(Arrays.toString(data));
    bubbleSort2(data);
    System.out.println(Arrays.toString(data));

  }
}
