package lesson06;

import static lesson06.DayOfWeek.Monday;

public class EnumApp {

  static final int ACTIVE = 2;
  static final int DONE = 3;

  public static void main(String[] args) {

    DayOfWeek day = Monday;
    OrderStatus status = OrderStatus.Done;

    String s = status.toString();
    System.out.println(s);

//    DayOfWeek day2 = DayOfWeek.valueOf("InProcess"); // No enum constant EX
    DayOfWeek day3 = DayOfWeek.valueOf("Saturday");

//    String s1 = "Done";
//    String s2 = "DONE";
//    String s3 = "done";

  }

}
