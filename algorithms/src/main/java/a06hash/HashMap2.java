package a06hash;

public class HashMap2 {

  int size;
  Integer[] keys;
  int[] values;

  public HashMap2(int size) {
    this.size = size * 2;
    this.keys = new Integer[size];
    this.values = new int[size];
  }

  private int hash(int k) {
    return k % size;
  }

  public void put(int k, Integer v) {
    int index = hash(k);
    if (keys[index] != null) {
      //findNextAvailableCell(index)
      throw new IllegalArgumentException("duplicate key");
    }
    keys[index] = k;
    values[index] = v;
  }

  public Integer get(int k) {
    int index = hash(k);
    //findCellWithKey(index, k) + check k == keys[index]
    if (keys[index] == null) {
      throw new IllegalArgumentException("no key");
    }
    return values[index];
  }

}
