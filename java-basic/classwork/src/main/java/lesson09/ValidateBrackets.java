package lesson09;

public class ValidateBrackets {

  public boolean validate(String s) {
    int depth = 0;
    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case '(': depth++; break;
        case ')': if (depth == 0) return false; depth--;
        default:
      }
    }
    return depth == 0;
  }

}
