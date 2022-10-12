package lesson09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class LetterCountApp1 {

  static int[] countLetters(String s) {
    int arraySize = 'z' - 'a' + 1; // 26
    int[] counter = new int[arraySize];
    for (int i = 0; i < s.length(); i++) {
      char sym = s.charAt(i);
      if (!Character.isLetter(sym)) continue;
      char c = Character.toLowerCase(sym);
      int index  = c - 'a';
      counter[index]++;
    }
    return counter;
  }

  static Collection<LC> represent(int[] counted) {
    ArrayList<LC> lcs = new ArrayList<>();
    for (int idx = 0; idx < counted.length; idx++) {
      int cnt = counted[idx];
      if (cnt == 0) continue;
      char letter = (char) (idx + 'a');
      LC lc = new LC(letter, cnt);
      lcs.add(lc);
    }
    return lcs;
  }

  /**
   * a : 3
   * b : 4
   * w/o zeroes
   */
  public static void main_v0(String[] args) {
    int[] counted = countLetters("Hello World!");
    for (char i = 'a'; i <= 'z'; i++) {
      System.out.printf(" %c ", i);
    }
    System.out.println();
    System.out.println(Arrays.toString(counted));
  }

  public static void main(String[] args) {
    int[] counted = countLetters("Hello World!");
    Collection<LC> r = represent(counted);
    System.out.println(r);
  }

}
