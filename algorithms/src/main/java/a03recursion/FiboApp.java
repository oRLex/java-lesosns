package a03recursion;

public class FiboApp {

  public long fibo1(long n) {
    if (n == 1 || n == 2) return 1;
    long f1 = fibo1(n - 1);
    long f2 = fibo1(n - 2);
    long f = f1 + f2;
    return f;
  }

  private long fibox(long n, long[] a) {
    if (n == 1 || n == 2) return 1;
    if (a[(int)n] > 0) return a[(int)n];
    long n1 = fibox(n-1, a);
    long n2 = fibox(n-2, a);
    long n0 = n1+n2;
    a[(int)n] = n0;
    return n0;
  }

  public long fibor2(long n) {
    long[] a = new long[(int) (n+1)];
    a[1] = 1;
    a[2] = 1;
    return fibox(n, a);
  }

  public long fibo(long n) {
    long[] a = new long[(int) (n+1)];
    a[1] = 1;
    a[2] = 1;
    for (int i = 3; i <= n; i++) {
      a[i] = a[i-1] + a[i-2];
    }
    return a[(int) n];
  }


}
