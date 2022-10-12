package lesson08.collections;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ArrayListApp {

  public static void main(String[] args) {
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    ArrayList<String> list2 = new ArrayList<String>();
    list1.add(5);
    list1.add(7);
    list1.add(12);
//    list1.add(true);
    list2.add("Abc");

    int size = list1.size();
    list1.add(0, 100);
    list1.add(200);
    list1.get(3);
    list1.set(0, 500);
//    list1.remove(500); // index
    list1.remove((Integer) 500); // value
    list1.lastIndexOf(500);
    list1.indexOf(500);
    list1.contains(500);
    System.out.println(list1);

    Integer seven = new Integer(7);
    Integer seven1 = Integer.valueOf(7);
    seven = new Integer(8);

    for (int x: list1) {
      System.out.printf("x=%d\n", x);
    }

    list1.forEach((Integer x) -> new Consumer<Integer>() {
      @Override
      public void accept(Integer integer) {
          System.out.printf("x=%d\n", x);
      }
    });


  }
}
