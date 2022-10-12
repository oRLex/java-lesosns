package lesson07.animals;

import java.lang.reflect.Constructor;
import java.util.List;

public class Application {

  public void doWithDog(Dog d) {}

  public void doSomething(Animal a) {
    a.sound();
    System.out.println("====");
  }

  public void process(List<Animal> as) {
    as.forEach(a -> doSomething(a));
  }

  public static void main(String[] args) {
    Animal c = new Cat();
    Dog d = new Dog();
    Fish f = new Fish();

    Application app = new Application();
    app.doSomething(c);
    app.doSomething(d);
    app.doSomething(f);
    app.doWithDog(d);
    c.die();
    d.die();

  }

}
