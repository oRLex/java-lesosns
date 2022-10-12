package a01sort;

public class MergeApp {

  /**
   * a = [1,5,7,9]
   * b = [3,6,100,500]
   * [1,3,5,6,7,9,100,500]
   */
  public int[] merge(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < a.length && j < b.length)
      if (a[i] < b[j]) c[k++] = a[i++];
      else             c[k++] = b[j++];

    while (i < a.length) c[k++] = a[i++];
    while (j < b.length) c[k++] = b[j++];
    return c;
  }

}
