package lesson12.iot;

public class App {

  public static void main(String[] args) {
    Sensor x = new WiFiTempSensor();
    Motor m = null;

    SmartMotor sm = null;

    sm.on();
    sm.speedDown();

    m.on();
    m.off();

    int temp = x.read();
  }
}
