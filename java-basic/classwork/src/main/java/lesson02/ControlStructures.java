package lesson02;

public class ControlStructures {

  void if_statement(int x) {
    if (x > 0) {
      System.out.printf("x=%d (>0)", x);
    } else {
      System.out.printf("x=%d (<=0)", x);
    }
  }

  void switch_statement(int x) {
    switch (x) {
      case 1:
        System.out.println("1");
        break;
      case 2:
        System.out.println("2");
        break;
      case 3:
        System.out.println("3");
        break;
      default:
        System.out.println("something else");
    }


  }

  void tern(int x) {
    String r = x > 0 ? "gt0" : "le0";
  }

  String tern2(boolean cond, String ifTrue, String ifFalse) {
    String r;
    if (cond) {
      r = ifTrue;
    } else {
      r = ifFalse;
    }
    return r;
  }

  static <A> A tern3(boolean cond, A ifTrue, A ifFalse) {
    A r;
    if (cond) {
      r = ifTrue;
    } else {
      r = ifFalse;
    }
    return r;
  }

  static void for_1() {

    for (int i = 1; i < 10; i++) {
      System.out.printf("i=%d\n", i);
    }

    for (int i = 1; i < 10;) {
      System.out.printf("i=%d\n", i);
      i++;
    }

    int j;
    for (j = 1; j < 10;) {
      System.out.printf("i=%d\n", j);
      j++;
    }

    // anti-pattern
    int i = 1;
    for (; i < 10;) {
      System.out.printf("i=%d\n", i);
      i++;
    } // i = 10

    for (;;) {
      System.out.printf("k=%d\n", i);
      if (i == 13) break;
      i++;
    }

    while (i < 20) {
      System.out.printf("w=%d\n", i);
      i++;
    } // i = 20

    do {
      System.out.printf("x=%d\n", i);
    } while (i<20);

  }

  public static void main(String[] args) {
    int x = 5;
    int a = tern3(x > 0, 11, 12);
    String s = tern3(x > 0, "A", "B");
    boolean res = tern3(x > 0, true, false);

    for_1();
  }

}
