package lesson09;

import java.util.HashMap;
import java.util.Map;

public class LetterCountApp3 {

  public static Map<Character, Integer> countLetters(String s) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char sym = s.charAt(i);
      if (!Character.isLetter(sym)) continue;
      char c = Character.toLowerCase(sym);
      //////////////
      if (map.containsKey(c)) {
        Integer cnt = map.get(c);
        map.put(c, cnt + 1);
      } else {
        map.put(c, 1);
      }
      //////////////
    }

    return map;
  }

  public static void main(String[] args) {
    Map<Character, Integer> lcs = countLetters("Hello World!");
    System.out.println(lcs);
  }
}
