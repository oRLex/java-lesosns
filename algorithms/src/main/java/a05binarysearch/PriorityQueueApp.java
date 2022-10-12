package a05binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueApp {

  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    List<Integer> xs = new ArrayList<>();
    new Random().ints(10,50)
      .distinct()
      .limit(20)
      .peek(pq::add)
      .forEach(xs::add);

    System.out.println(xs);
    System.out.println(pq);

    while (!pq.isEmpty()) {
      System.out.print(pq.poll()+" ");
    }
  }
}
