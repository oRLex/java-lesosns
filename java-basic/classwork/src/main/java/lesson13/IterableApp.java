package lesson13;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IterableApp {

  public static void main(String[] args) {
    Months ms = new Months();

    Iterator<String> it = ms.iterator();
    while (it.hasNext()) {
      String month = it.next();
      System.out.printf("%s ", month);
    }
    System.out.println();

    Iterator<String> it2 = ms.reverseIterator();
    while (it2.hasNext()) {
      String month = it2.next();
      System.out.printf("%s ", month);
    }
    System.out.println();

    for (Iterator<String> it3 = ms.randomIterator(); it3.hasNext();) {
      String month = it3.next();
      System.out.printf("%s ", month);
    }
    System.out.println();

    for (String month: ms) {
      System.out.printf("%s ", month);
    }
    System.out.println();

  }
}
