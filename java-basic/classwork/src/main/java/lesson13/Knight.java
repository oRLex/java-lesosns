package lesson13;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Knight {

  static class Point {
    final int dx;
    final int dy;

    Point(int dx, int dy) {
      this.dx = dx;
      this.dy = dy;
    }

    @Override
    public String toString() {
      return String.format("[%d : %d]", dx, dy);
    }
  }
  static List<Integer> a2 = Arrays.asList(1, 2);

  public static void main1(String[] args) {
    List<Integer> a4 = a2
        .stream()
        .flatMap(x -> Stream.of(-x, x))
        .collect(Collectors.toList());

    a4.stream() // stream<Int>
        .flatMap(x ->
            a4.stream() // stream<Int>
                .filter(y -> Math.abs(x) != Math.abs(y))
                .map(y -> new Point(x, y))
        ) // stream<Point>
        .forEach(x -> System.out.printf("%s ", x));
  }

  public static void main(String[] args) {
    List<Integer> ints = Arrays.asList(1, 2, 3, null, 4, 5, null, 6, 7);
    String collect = ints.stream()
        .flatMap(x -> {
          if (x == null) return Stream.empty();
          else return Stream.of(x);
        })
        .map(Object::toString)
        .collect(Collectors.joining(" ", "<", ">"));
//        .forEach(x -> System.out.printf("%d ", x));

  }

}
