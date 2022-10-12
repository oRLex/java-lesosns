package lesson07.figures_int;

import lesson07.figures_ac.Utils;

public class Square implements HasArea {

  public final double side;

  public Square(double side) {
    this.side = side;
  }

  public static Square random() {
    return new Square(Utils.random());
  }

  @Override
  public double area() {
    return side * side;
  }
}
