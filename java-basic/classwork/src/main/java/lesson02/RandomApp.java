package lesson02;

import java.util.Random;

public class RandomApp {

  public static void main1(String[] args) {
    double x = Math.random(); // [0, 1)
    double y = x * 10;// [0,10)
    double z = y + 1; // [1,11)
    int r = (int) z;  // [1,10]
    int min = 100;
    int max = 200;
    int delta = max - min + 1;
    double r100to200 = x * delta + min; // [min, max]
  }

  public static void main2(String[] args) {
    int x = (int) (Math.random() * 10);
    System.out.println(x);
  }

  public static void main(String[] args) {
    Random random = new Random(83476);
//    int x = random.nextInt(100); //[0,100)
//    System.out.println(x);
    int[] ints = random
        .ints(10, 20)
        .limit(10)
        .toArray();
//        .forEach(x -> System.out.println(x));

    for (int i = 0; i < ints.length; i++) {
      System.out.printf("a=%d ", ints[i]);
    }
    System.out.println();

    for (int a: ints) {
      System.out.printf("a=%d ", a);
    }


  }
}
