package t02glovo;

import java.util.Optional;
import java.util.stream.LongStream;

public class Task1 {

  public long b_optimized(int n, int k) {
    long top = LongStream.rangeClosed(n-k+1, n).reduce((a, b) -> a * b).getAsLong();
    long bottom = LongStream.rangeClosed(1, n-k-1).reduce((a, b) -> a * b).getAsLong();
    return top / bottom;
  }

  public long b(int n, int k) {
    Optional<Long> top = LongStream.rangeClosed(1, n).boxed().reduce((a, b) -> a * b);
    Optional<Long> bottom1 = LongStream.rangeClosed(1, k).boxed().reduce((a, b) -> a * b);
    Optional<Long> bottom2 = LongStream.rangeClosed(1, n-k).boxed().reduce((a, b) -> a * b);

    return top.flatMap(t ->
        bottom1.flatMap(b1 ->
          bottom2.map(b2 ->
            t/(b1*b2)
          )
        )
      )
      .orElseThrow();

  }

}
