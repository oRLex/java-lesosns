package webYvalidation;

public class ValidationIdeas1 {

  static String message1 = "string mustn't be empty!";
  static String message2 = "string should be longer that 5 chars";

  static <A> boolean validate(A a) {
    throw new IllegalArgumentException();
  }

  static boolean validateNonEmpty(String name) {
    return !name.isEmpty();
  }

  static boolean validateLenGt5(String name) {
    return name.length() > 5;
  }

  public static void main(String[] args) {
    String name = "Jim";
    boolean r1 = validateNonEmpty(name);
    boolean r2 = validateLenGt5(name);
  }

}
