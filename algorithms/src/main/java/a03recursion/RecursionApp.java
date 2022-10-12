package a03recursion;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class RecursionApp {

  int facts(int n) {
    return IntStream.rangeClosed(1, n)
      .reduce(1, (a, b) -> a * b);
  }

  int fact(int n) {
    int r = 1;
    for (int i = 1; i <= n; i++) {
      r = r * i;
    }
    return r;
  }

  int factr(int n) {
    if (n == 1) return 1;
    return n * factr(n - 1);
  }

  int facttr(int n, int a) {
    if (n == 1) return a;
    return facttr(n - 1, a * n);
  }

  int facttr(int n) {
    return facttr(n, 1);
  }


}
