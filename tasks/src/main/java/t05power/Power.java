package t05power;

public class Power {

  public int last1(int n) {
    int r = 1;
    for (int i = 1; i <= n; i++) {
      r = r * 7 % 10;
    }
    return r;
  }

  public static int last(int n) {
    int[] digits = {1,7,9,3};
    int last = digits[n % 4];
    return last;
  }

  public static void main(String[] args) {
    System.out.println(last(100)); // 1
    System.out.println(last(101)); // 7
    System.out.println(last(102)); // 9
    System.out.println(last(103)); // 3
  }

}
