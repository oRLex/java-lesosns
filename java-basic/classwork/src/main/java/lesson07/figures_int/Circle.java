package lesson07.figures_int;

import lesson07.figures_ac.Utils;

public class Circle implements HasArea {

  public final double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public static Circle random() {
    return new Circle(Utils.random());
  }

  @Override
  public double area() {
    return radius * radius * Math.PI;
  }

}
