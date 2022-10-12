package webX;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorExample {
  public static void main(String[] args) {
    List<Integer> ints = new Random().ints(10, 40).limit(10).boxed()
      .collect(new Collector<Integer, List<Integer>, List<Integer>>() {
        @Override
        public Supplier<List<Integer>> supplier() {
          return () -> new ArrayList<>();
        }

        @Override
        public BiConsumer<List<Integer>, Integer> accumulator() {
          return (li, x) -> li.add(x);
        }

        @Override
        public BinaryOperator<List<Integer>> combiner() {
          return (l1, l2) -> {
            l1.addAll(l2);
            return l1;
          };
        }

        @Override
        public Function<List<Integer>, List<Integer>> finisher() {
          return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
          return Collections.emptySet();
        }
      });
    System.out.println(ints);
  }
}
