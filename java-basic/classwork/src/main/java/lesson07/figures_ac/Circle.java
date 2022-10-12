package lesson07.figures_ac;

public class Circle extends Figure {

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
