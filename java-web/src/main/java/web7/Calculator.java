package web7;

import java.util.Optional;
import java.util.function.BiFunction;

public class Calculator {

  static Optional<Integer> toInt(String s) {
    try {
      return Optional.of(Integer.parseInt(s));
    } catch (NumberFormatException x) {
      return Optional.empty();
    }
  }

  static Optional<BiFunction<Integer, Integer, Integer>> parseOp(String s) {
    switch (s) {
      case "add": return Optional.of((a, b) -> a + b);
      case "sub": return Optional.of((a, b) -> a - b);
      case "mul": return Optional.of((a, b) -> a * b);
      case "div": return Optional.of((a, b) -> a / b);
    }
    return Optional.empty();
  }

  static String represent(int x, int y, String op, int r) {
    return String.format("%d %s %d = %d", x, op, y, r);
  }

  public String doCalc(String sx, String sy, String sop) {
    Optional<Integer> ox = toInt(sx);
    Optional<Integer> oy = toInt(sy);
    Optional<BiFunction<Integer, Integer, Integer>> oop = parseOp(sop);

    return ox.flatMap(x ->
      oy.flatMap(y ->
        oop.map(op -> {
            int r = op.apply(x, y);
            return represent(x, y, sop, r);
          }
        )
      )
    )
      .orElse("Wrong value given");
  }

}
