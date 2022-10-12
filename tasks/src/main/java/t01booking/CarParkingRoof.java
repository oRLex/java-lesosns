package t01booking;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CarParkingRoof {

  long minRoofLen0(long[] cars, int k) {
    Arrays.sort(cars);
    final int l = cars.length;
    long minLen = Integer.MAX_VALUE;
    for (int idx = 0; idx < l - k + 1; idx++) {
      long curLen = cars[idx + k - 1] - cars[idx] + 1;
      minLen = Math.min(minLen, curLen);
    }
    return minLen;
  }

  long minRoofLen(long[] cars, int k) {
    Arrays.sort(cars);
    return IntStream.range(0, cars.length - k + 1)
      .mapToLong(idx -> cars[idx + k - 1] - cars[idx] + 1)
      .min()
      .orElseThrow();
  }

}
