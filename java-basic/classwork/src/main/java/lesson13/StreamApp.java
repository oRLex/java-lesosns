package lesson13;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamApp {


  public static void main(String[] args) {

    List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> ints2 = new ArrayList<>();
    for (int x: ints) {
      int x2 = x * 2;
      ints2.add(x2);
    }

    Collector<Integer, List<Integer>, List<Integer>> myCollector = new Collector<Integer, List<Integer>, List<Integer>>() {
      @Override
      public Supplier<List<Integer>> supplier() {
        return () -> new ArrayList<>();
      }

      @Override
      public BiConsumer<List<Integer>, Integer> accumulator() {
        return new BiConsumer<List<Integer>, Integer>() {
          @Override
          public void accept(List<Integer> xs, Integer x) {
            xs.add(x);
          }
        };
      }

      @Override
      public BinaryOperator<List<Integer>> combiner() {
        return new BinaryOperator<List<Integer>>() {
          @Override
          public List<Integer> apply(List<Integer> xs1, List<Integer> xs2) {
            ArrayList<Integer> xs3 = new ArrayList<>();
            xs3.addAll(xs1);
            xs3.addAll(xs2);
            return xs3;
          }
        };
      }

      @Override
      public Function<List<Integer>, List<Integer>> finisher() {
        return new Function<List<Integer>, List<Integer>>() {
          @Override
          public List<Integer> apply(List<Integer> xs) {
            return xs;
          }
        };
      }

      @Override
      public Set<Characteristics> characteristics() {
        return Collections.emptySet();
      }
    };

    List<Integer> ints2a = ints.stream()
        .map(x -> x * 2)
        .collect(myCollector);

    List<Integer> ints3a = ints.stream()
        .filter(x -> x > 0)
        .collect(myCollector);

    Map<Boolean, List<Integer>> collected1 = ints.stream()
        .collect(Collectors.groupingBy(x -> x % 2 == 0));

    long count = ints.stream()
        .filter(x -> x > 0)
        .limit(100)
        .count();

    System.out.println(collected1);


  }

}
