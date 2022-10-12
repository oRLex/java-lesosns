package lesson03;

public class ArraysSyntax {

  public static void process(int[] a) {

  }

  public static void main(String[] args) {

    /** way 1 */
    int[] a = {10,20,30};
    process(a);

    /** doesn't work */
//    process({10,20,30});

    /** way 2 */
    process(new int[]{10,20,30});
  }
}
