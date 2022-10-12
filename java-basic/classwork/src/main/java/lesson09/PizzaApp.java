package lesson09;

import java.util.ArrayList;

public class PizzaApp {
  public static void main(String[] args) {
    ArrayList<Pizza> pizzas = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      pizzas.add(Pizza.random());
    }
    pizzas.removeIf(p -> p.size <= 30);
    pizzas.forEach(p -> System.out.println(p));
  }
}
