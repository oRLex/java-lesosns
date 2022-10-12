package lesson07.figures_ac;

public class Square extends Figure {

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
