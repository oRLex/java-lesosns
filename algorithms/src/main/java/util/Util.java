package util;

public class Util {

  public static RuntimeException ex(String text) {
    throw new IllegalArgumentException(text);
  }

  public static RuntimeException NI = ex("not implemented yet");

}
