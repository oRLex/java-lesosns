package a02bit;

public class Taxi {

  final static byte touring   = 0b00000001;
  final static byte smoking   = 0b00000010;
  final static byte pets      = 0b00000100;
  final static byte condition = 0b00001000;

  static class Order {
    private byte prop;

    boolean isTouring() {
      return (prop & touring) > 0;
    }

    boolean isSmoking() {
      return (prop & smoking) > 0;
    }

    void setTouring() {
      prop = (byte) (prop | touring);
    }

    void clearTouring() {
      prop = (byte) (prop & ~touring);
    }

  }

  public static void main(String[] args) {
    Order o = new Order();
    o.setTouring();
    if (o.isTouring()) {
      //
    }
  }
}
