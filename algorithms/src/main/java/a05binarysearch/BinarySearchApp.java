package a05binarysearch;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

import static util.Util.NI;

public class BinarySearchApp {

  // bad
  public Optional<Integer>[] indexOf4(int[] data, int value) {
    throw NI;
  }

  public SResult indexOf3(int[] data, int value) {
    int l = 0;
    int r = data.length - 1;

    while (r >= l) {
      int m = (l + r) / 2;
      System.out.println(m);
      if (value == data[m]) return SResult.foundAt(m);
      if (value < data[m]) r = m - 1;
      else if (value > data[m]) l = m + 1;
    }
    return SResult.insertAt(l);
  }

  public Optional<Integer> indexOf(int[] data, int value) {
    int l = 0;
    int r = data.length - 1;

    while (r >= l) {
      int m = (l + r) / 2;
      System.out.println(m);
      if (value == data[m]) return Optional.of(m);
      if (value < data[m]) r = m - 1;
      else if (value > data[m]) l = m + 1;
    }

    return Optional.empty();
  }

  public boolean contains2(int[] data, int value) {
    return indexOf(data, value).isPresent();
  }

  public boolean contains_i(int[] data, int value) {
    int l = 0;
    int r = data.length - 1;

    while (r >= l) {
      int m = (l + r) / 2;
      if (value == data[m]) return true;
      if (value < data[m]) r = m - 1;
      else if (value > data[m]) l = m + 1;
    }

    return false;
  }

  public boolean contains(int[] data, int value, int l, int r) {
    if (r < l) return false;
    int m = (l + r) / 2;
    if      (value < data[m]) return contains(data, value, l, m - 1);
    else if (value > data[m]) return contains(data, value, m + 1, r);
    else /* value == data[m] */ return true;
  }

  public boolean contains(int[] data, int value) {
    return contains(data, value, 0, data.length - 1);
  }

  public int[] data() {
    int[] data = new Random()
      .ints(10, 50)
      .distinct()
      .limit(20)
      .toArray();
    Arrays.sort(data);
    return data;
  }

  static class Person implements Comparable<String> {
    String name;

    @Override
    public int compareTo(String o) {
      return name.compareTo(o);
    }
  }

  public static void main(String[] args) {
    BinarySearchApp bs = new BinarySearchApp();
    System.out.println(Arrays.toString(bs.data()));
    Optional<Integer>[] optionals = bs.indexOf4(bs.data(), 33);

    int[] data = bs.data();
    Arrays.binarySearch(data, 5);
    ArrayList<Person> as = new ArrayList<>();
    as.add(new Person());
    as.add(new Person());
    as.add(new Person());
    int found = Collections.binarySearch(as, "Alex"); // Log(N)

  }
}
