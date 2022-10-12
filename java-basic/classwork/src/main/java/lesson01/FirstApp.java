package lesson01;

public class FirstApp {

  public static int add(int a, int b) {
    return a + b;
  }

  public static int doSomething(int x, int y) {
    return x * y;
  }

  public static void main(String[] args) {
    System.out.println("Hello, World!");

    int c1 = add(1,2);
    int c2 = doSomething(1,2);
  }

}
