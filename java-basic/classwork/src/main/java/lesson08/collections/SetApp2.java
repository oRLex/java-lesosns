package lesson08.collections;

import java.util.HashSet;

public class SetApp2 {
  public static void main(String[] args) {
    HashSet<Short> set = new HashSet<>();
    for (short i = 0; i < 100; i++) {
      set.add(i);
      int i1 = i - 1;
      set.remove((short)(i - 1));
    }
    System.out.println(set.size());
    System.out.println(set);
  }
}
