package lesson07.figures_ac;

public abstract class Figure {

//  public static Figure random(Class<?>... fs) {}
//  public static Figure random(List<Class<?>>... fs) {}

  public static Figure random() {
    switch ((int) (Math.random() * 3)) {
      case 0: return Circle.random();
      case 1: return Rectangle.random();
      case 2: return Square.random();
      default: throw new IllegalArgumentException("shouldn't be there...");
    }
  }

  public abstract double area();

  @Override
  public String toString() {
    Class<? extends Figure> clazz = getClass();
    return clazz.getSimpleName();
  }
}
