package concurrency;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class App {

  static class Box {

    int i = 0;

    synchronized void inc() {
      int k = i;
      //
      k = k + 1;
      //
      i = k;
    }

    synchronized void dec() {
      int k = i;
      k = k - 1;
      i = k;
    }

  }

  public static void main(String[] args) throws InterruptedException {
    Box box = new Box();

    Runnable r1 = () -> IntStream.range(0, 10_000).forEach(x -> box.inc());
    Runnable r2 = () -> IntStream.range(0, 10_000).forEach(x -> box.dec());

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.start();
    t2.start();

    Thread.sleep(100);

    System.out.println(box.i);

    AtomicReference<Integer> x;


  }


}
