package a06hash;

public class HashApp {

  public static void main(String[] args) {
    HashMap2 m = new HashMap2(100);
    m.put(345, 1000);
    m.put(567, 2000);
    m.put(567, 2001);

    System.out.println(m.get(345)); // 1000
    System.out.println(m.get(567)); // 2000
    System.out.println(m.get(457)); // ex

  }
}
