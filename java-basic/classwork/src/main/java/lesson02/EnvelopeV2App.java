package lesson02;

public class EnvelopeV2App {

  public static void print(String s) {
    System.out.print(s);
  }

  public static void main(String[] args) {
    int WIDTH = 30;
    int HEIGHT = 10;
    int k = WIDTH / HEIGHT;
    for (int y = 1; y <= HEIGHT; y++) {
      for (int x = 1; x <= WIDTH; x++) {
        // x:  1....10
        // x1: 10....1
        int x1 = WIDTH - x + 1;
        boolean isBorder = y == 1 || y == HEIGHT || x == WIDTH || x == 1;
        boolean isDiagonal = x == y * k || y * k == x1;
        boolean isVisible = isBorder || isDiagonal;
        print(isVisible ? "*" : " ");
      }
      print("\n");
    }

  }
}
