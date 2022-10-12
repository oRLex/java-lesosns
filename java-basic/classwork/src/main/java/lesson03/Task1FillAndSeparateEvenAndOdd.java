package lesson03;

import java.util.Arrays;
import java.util.function.Function;

/**
 * 1. create an array with length=20
 * 2. fill it wit random values in range [10, 30]
 * 3. filter even elements
 * 4. filter odd elements
 */
public class Task1FillAndSeparateEvenAndOdd {

  public static int randomRange(int min, int max) {
    int delta = max - min;
    return (int) (Math.random()*(delta + 1 ) + min);
  }

  public static int[] randoms(int n, int min, int max) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = randomRange(min, max);
    }
    return a;
  }

  /**
   * memory complexity: 2 * N
   * time complexity:   1 * N
   */
  public static void calculateV1(int[] randoms) {
    int N = randoms.length;
    System.out.printf("Initial: %s\n", Arrays.toString(randoms));
    int[] evens0 = new int[N];
    int[] odds0 = new int[N];
    int ei = 0;
    int oi = 0;
    for (int a: randoms) {
      if(a % 2 == 0) {
        evens0[ei++] = a;
      } else {
        odds0[oi++] = a;
      }
    }
    int[] evens = Arrays.copyOf(evens0, ei);
    int[] odds = Arrays.copyOf(odds0, oi);
    System.out.printf("Evens: %s\n", Arrays.toString(evens));
    System.out.printf("Odds:  %s\n", Arrays.toString(odds));
  }

  public static int count_evens(int[] data) {
    int cnt = 0;
    for (int x: data) {
      if (x % 2 == 0) cnt++;
    }
    return cnt;
  }

  public static int count_odds(int[] data) {
    int cnt = 0;
    for (int x: data) {
      if (x % 2 != 0) cnt++;
    }
    return cnt;
  }

  public static int count(int[] data, Function<Integer, Boolean> predicate) {
    int cnt = 0;
    for (int x: data) {
      if (predicate.apply(x)) cnt++;
//      cnt = cnt + (predicate.apply(x) ? 1 : 0);
    }
    return cnt;
  }

  /**
   * memory complexity: 1 * N
   * time complexity:   3 * N
   */
  public static void calculateV2(int[] randoms) {
    int count_evens = count(randoms, x -> x % 2 == 0); // N
    int count_odds = count(randoms, x -> x % 2 != 0); // N
    int[] evens = new int[count_evens];
    int[] odds = new int[count_odds];
    int ei = 0;
    int oi = 0;
    for (int a: randoms) {
      if(a % 2 == 0) {
        evens[ei++] = a;
      } else {
        odds[oi++] = a;
      }
    }

    System.out.printf("Initial: %s\n", Arrays.toString(randoms));
    System.out.printf("Evens:   %s\n", Arrays.toString(evens));
    System.out.printf("Odds:    %s\n", Arrays.toString(odds));
  }

  public static void main(String[] args) {
    int N = 20;
    int[] randoms = randoms(N, 10, 30);
//    calculateV1(randoms);
    calculateV2(randoms);

  }
}
