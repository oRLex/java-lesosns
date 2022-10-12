package lesson09;

public class StringApp {

  static class Counter {
    final int vowel;
    final int consonant;

    Counter(int vowel, int consonant) {
      this.vowel = vowel;
      this.consonant = consonant;
    }
  }

  public static boolean isVowel(char c) {
    return "aeoiu".contains(String.valueOf(Character.toLowerCase(c)));
  }

  public static Counter count(String s) {
    int v = 0;
    int c = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isLetter(ch)) {
        if (isVowel(ch)) v++; else c++;
      }
    }
    return new Counter(v, c);
  }

  public static int[] count2(String s) {
    throw new IllegalArgumentException();
  }

  public static int count_vowel(String s) {
    throw new IllegalArgumentException();
  }

  public static int count_consonant(String s) {
    throw new IllegalArgumentException();
  }

  public static void main(String[] args) {
    Counter r = count("Hello world!");
    System.out.printf("Vowels: %d\n", r.vowel);
    System.out.printf("Consonants: %d\n", r.consonant);
  }

}
