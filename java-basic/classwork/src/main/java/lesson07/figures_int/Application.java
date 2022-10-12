package lesson07.figures_int;

import java.util.ArrayList;

public class Application {
  public static void main(String[] args) {
    ArrayList<HasArea> al = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      al.add(Utils2.random());
    }

    al.forEach(f -> System.out.printf("I'm %s, my area is: %f\n", f.toString(), f.area()));
  }
}
