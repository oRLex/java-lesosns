package a09lee;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class LongRunApp {

//  AtomicBoolean terminate = new AtomicBoolean(false);

  /**
   * 1991
   * 486DX
   *
   * CAS
   *
   * i++
   */

  public int Long(Boolean terminate) {
    int[] as = new int[10000];
    int r = 0;
    for (int a: as) {
      if (terminate) return r;
      r += a;
    }
    return r;
  }

}
