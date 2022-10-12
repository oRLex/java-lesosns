package lesson07.figures_ac;

import java.util.ArrayList;

public class Application {
  public static void main(String[] args) {
    Circle circle = new Circle(4);
    Rectangle rectangle = new Rectangle(3, 5);
    Square square = new Square(5);
    System.out.println(circle.area());
    System.out.println(rectangle.area());
    System.out.println(square.area());
    Circle circle2 = Circle.random();
    Rectangle rect2 = Rectangle.random();
    Square sq2 = Square.random();

    ArrayList<Figure> al = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
//      al.add(Figure.random(Rectangle.class, Square.class));
      al.add(Figure.random());
    }

    al.forEach(f -> System.out.printf("I'm %s, my area is: %f\n", f.toString(), f.area()));
  }
}
