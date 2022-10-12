package lesson01;

public class StaticApp {

  static void print() {
    System.out.println("It works");
  }

  public static void main(String[] args) {
    ((StaticApp) null).print();
    StaticApp.print();
  }
}
