package lesson09;

public class Month {

  public static int count(int n) {
                        //  1  2  3  4  5  6  7  8  9 10 11 12
    int n1  = n - 1;    //  0  1  2  3  4  5  6  7  8  9 10 11
    int m7  = n1 % 7;   //  0  1  2  3  4  5  6  0  1  2  3  4
    int m72 = m7 % 2;   //  0  1  0  1  0  1  0  0  1  0  1  0

    int a = 13 - n;     // 12 11 10  9  8  7  6  5  4  3  2  1
    int b = a / 11;     //  1  1  0  0  0  0  0  0  0  0  0  0
    int c = a / 12;     //  1  0  0  0  0  0  0  0  0  0  0  0
    int f = b ^ c;      //  0  1  0  0  0  0  0  0  0  0  0  0

    return 31 - m72 - f * 2;
  }

}
