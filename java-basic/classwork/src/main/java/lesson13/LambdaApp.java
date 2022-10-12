package lesson13;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaApp {

  public static void printMe(int x) {
    System.out.println(x);
  }

  public static void main(String[] args) {
    List<Integer> ints = Arrays.asList(1, 2, 3);

    for (int x: ints) {
      System.out.println(x);
    }

    Consumer<Integer> consumer1 = new Consumer<Integer>() {
      @Override
      public void accept(Integer x) {
        System.out.println(x);
      }
    };
    Consumer<Integer> consumer2 = (Integer x) -> {
      System.out.println(x);
    };
    Consumer<Integer> consumer3 = (x) -> {
      System.out.println(x);
    };
    Consumer<Integer> consumer4 = (x) -> System.out.println(x);
    Consumer<Integer> consumer5 = System.out::println;
    Consumer<Integer> consumer6 = x -> LambdaApp.printMe(x);
    Consumer<Integer> consumer7 = LambdaApp::printMe;

    ints.forEach(consumer1);
    ints.forEach(x -> LambdaApp.printMe(x));
    ints.forEach((x) -> LambdaApp.printMe(x));
    ints.forEach((Integer x) -> LambdaApp.printMe(x));
    ints.forEach(LambdaApp::printMe);

    ints.forEach(new Consumer<Integer>() {
      @Override
      public void accept(Integer x) {
        System.out.println(x);
      }
    });

    ints.forEach(System.out::println);

    // anon class
    Arrays.asList(1, 2, 3).forEach(System.out::println);
  }

}
