package a03recursion;

public class SplitApp {

  public static void split(int min, int max) {
    System.out.printf("given: %d:%d\n", min, max);
    if (min == max) return;
    System.out.println("splitting...");
    int mid = (max + min) / 2;
    split(min, mid);
    split(mid + 1, max);
  }

  public static void main(String[] args) {
    split(1, 8);
  }

}
