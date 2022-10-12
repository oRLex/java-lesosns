package t03tiles;

public class Tiles {

  public int comb(int n) {
    if (n < 3) return n;
    return comb(n - 1) + comb(n - 2);
  }

}
