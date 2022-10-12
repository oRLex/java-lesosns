package t01booking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarParkingRoofTest {

  private final CarParkingRoof t = new CarParkingRoof();

  @Test
  public void test1() {
    long[] data = {6,7,2,12};
    int len = 3;
    int expected = 6;
    long real = t.minRoofLen(data, len);
    assertEquals(expected, real);
  }

}
