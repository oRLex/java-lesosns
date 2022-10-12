package lesson09;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class LetterCountApp2 {

  public static boolean containsLetter(Collection<LC> lcs, char c) {
    for (LC lc: lcs) {
      if (lc.ch == c) return true;
    }
    return false;
  }

  public static Optional<LC> contains(Collection<LC> lcs, char c) {
    for (LC lc: lcs) {
      if (lc.ch == c) return Optional.of(lc);
    }
    return Optional.empty();
  }

  public static Collection<LC> countLetters(String s) {
    HashSet<LC> lcs = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char sym = s.charAt(i);
      if (!Character.isLetter(sym)) continue;
      char c = Character.toLowerCase(sym);
      //////////////
      Optional<LC> item = contains(lcs, c);
      if (item.isPresent()) {
        LC lc = item.get();
        lcs.remove(lc);
        lcs.add(new LC(c, lc.count + 1));
      } else {
        lcs.add(new LC(c, 1));
      }
      //////////////
    }
    return lcs;
  }

  public static void main(String[] args) {
    Collection<LC> lcs = countLetters("Hello World!");
    System.out.println(lcs);
  }
}
