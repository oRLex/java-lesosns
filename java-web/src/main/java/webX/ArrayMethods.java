package webX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayMethods {

  public static void main(String[] args) {
    List<Integer> as = Arrays.asList(1, 2, 3, 4, 5, 6, 7); // immutable list
    ArrayList<Integer> as2 = new ArrayList<>(as); // mutable list
    as2.removeIf(x -> x > 5);
    as2.forEach(x -> System.out.println(x));

    Stream<Integer> s0 = as.stream();
    Stream<Integer> s1 = s0
        .filter(x -> true)
        .map(x -> x + 1); // 2,3,4,5,6,7,8
    Stream<Integer> s2 = s1
        .flatMap(x -> Stream.of(x + 10, x + 100)); // 12, 102, 13, 103 ...
//    s2.forEach(x -> System.out.println(x));
//    s2.count();
//    s2.collect(Collectors.toList());

    Map<Boolean, List<Integer>> collected =
    s2.collect(Collectors.groupingBy(x -> x < 100));

    collected.forEach( (k, v) -> {
      System.out.printf("%s : %s\n", k, v);
    });

  }
}
