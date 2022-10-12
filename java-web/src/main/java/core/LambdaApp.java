package core;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class LambdaApp {

  static Function<Integer, Integer> add10a = x -> x + 10;

  static IntUnaryOperator add10c = x -> x + 10;

  static Function<Integer, Integer> add10b = new Function<Integer, Integer>() {
    @Override
    public Integer apply(Integer x) {
      return x + 10;
    }
  };

  static int add10(int x) {
    return x + 10;
  }

  public static void main1(String[] args) {
    IntStream.range(1, 5)
      .map(x -> x + 10)
      .forEach(System.out::println);
  }

  public static void main(String[] args) {
    IntStream.range(1, 5)
      .boxed()
      .map(LambdaApp::add10)
      .forEach(System.out::println);
  }

  public static void main3(String[] args) {
    IntStream.range(1, 5) // Stream<int> == IntStream
      .map(add10c)
      .forEach(System.out::println);
  }

  public static void main4(String[] args) {
    IntStream.range(1, 5) // Stream<int> == IntStream
      .boxed()            // Stream<Integer>
      .map(add10b)
      .forEach(System.out::println);
  }

}
