package lesson06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  @Test
  void add1() {
    int a = 5;
    int b = 4;
    int expected = 9;
    int real = Calculator.add(a, b);
    assertEquals(expected, real);
  }

  @Test
  void sub() {
    int a = 5;
    int b = 4;
    int expected = 1;
    int real = Calculator.sub(a, b);
    assertEquals(expected, real);
  }

  @Test
  void add2() {
    int a = 3;
    int b = -2;
    int expected = 1;
    int real = Calculator.add(a, b);
    assertEquals(expected, real);
  }

  @Test
  void add3() {
  }
}
