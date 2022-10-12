package lesson03;

import java.util.Arrays;

public class MultiDimArray {

  public static void main(String[] args) {
    int[][] b = new int[3][3];

    int[][] a = {
      {11,12},
      {21,22,23},
      {31,32,33,34},
      {}
    };

    int[] line0 = a[0];

    int x = a.length;    // 4
    int y = a[0].length; // 2
    int z = a[3].length; // 0

    System.out.println(Arrays.toString(line0));
    System.out.println(a);
    System.out.println(Arrays.toString(a));
  }

}
