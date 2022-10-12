package lesson07.figures_int;

public abstract class Utils2 {

  public static HasArea random() {
    switch ((int) (Math.random() * 3)) {
      case 0: return Circle.random();
      case 1: return Rectangle.random();
      case 2: return Square.random();
      default: throw new IllegalArgumentException("Utils2.random: wrong value generated $r shouldn't be there...");
    }
  }

}
