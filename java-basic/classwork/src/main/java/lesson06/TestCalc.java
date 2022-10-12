package lesson06;

public class TestCalc {


  public static void test1() {
    int a = 5;
    int b = 4;
    int expected = 9;
    int real = Calculator.add(a, b);
    if (real != expected) System.out.println("Error");

  }

  public static void main(String[] args) {
    test1();
  }

}
