package lesson01;

public class AppleApp {
  public static void main(String[] args) {
    System.out.println("Apple"
        + " costs " +
        + '2' +
        " USD"
    );
    System.out.println("Hello " + 53);
    String data = String.format("Apple costs %d USD", 2);
    String formatted = String.format("Apple costs %d USD", 2);
    System.out.printf("Apple costs %d USD", 2);
  }
}
