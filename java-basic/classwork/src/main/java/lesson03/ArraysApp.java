package lesson03;

import java.util.Arrays;

public class ArraysApp {
  public static void main1(String[] args) {
    int[] ints = new int[4];

    ints[0] = 10;
    ints[1] = 20;
    ints[2] = 30;
    ints[3] = 40;
//    ints[4] = 50; // ArrayIndexOutOfBoundsException
    System.out.println("---");
    for (int i = 0; i < 4; i++) {
      System.out.printf("a[%d]=%d\n", i, ints[i]);
    }
    System.out.println("---");
    for (int i = 0; i < ints.length; i++) {
      System.out.printf("a[%d]=%d\n", i, ints[i]);
    }
    System.out.println("---");

    for (int x: ints) {
      System.out.printf("a[i]=%d\n", x);
    }
    System.out.println("---");

    System.out.println(ints);
  }

  public static void main(String[] args) {
    int[] ints = new int[4];

    ints[0] = 10;
    ints[1] = 20;
    ints[2] = 30;
    ints[3] = 40;

    int[] ints2 = new int[10];

    String s1 = Arrays.toString(ints);
    String s2 = Arrays.toString(ints2);

    System.out.println(s1);
    System.out.println(s2);

    // slice
    int[] slice1 = Arrays.copyOf(ints, 2);// 10,20
    int[] slice2 = Arrays.copyOfRange(ints, 0, 3);// 10,20,30

    Arrays.fill(ints2, 33);
    System.arraycopy(ints, 1, ints2, 4, 3);
    String s22 = Arrays.toString(ints2);
    System.out.println(s22);
  }

}
