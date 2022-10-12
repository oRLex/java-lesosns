package lesson09;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BiFunction;

public class GenericsApp {


  public static <IN1, IN2, OUT> OUT doSomething(IN1 a, IN2 b, BiFunction<IN1, IN2, OUT> f) {
    IN1 a_copy = a;
    OUT result = f.apply(a, b);
    return result;
  }

  public static void main(String[] args) {

    int z;

    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();

    BiFunction<Integer, String, String> f = new BiFunction<Integer, String, String>() {
      @Override
      public String apply(Integer a, String s) {
        return String.format("%s : %d", s, a);
      }
    };

    BiFunction<Integer, String, String> f2 = (Integer a, String s) -> String.format("%s : %d", s, a);
    BiFunction<Integer, String, String> f3 = (a, s) -> String.format("%s : %d", s, a);

    String formatted1 = doSomething(33, "Hello", f);
    String formatted2 = doSomething(33, "Hello", (Integer a, String s) -> String.format("%s : %d", s, a));
    String formatted3 = doSomething(33, "Hello", (a, s) -> String.format("%s : %d", s, a));

//    int y;

    Optional<Integer> res1 =
        Optional.of(3).flatMap(x ->
            Optional.of(5).map((Integer y) -> { return y + x; })
        );


  }
}
