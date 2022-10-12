package a06hash;

import java.util.LinkedList;
import java.util.Optional;

public class HashMap3<K, V> {

  class Cell {
    K key;
    V value;

    public Cell(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  int size;
  LinkedList<Cell>[] data;

  public HashMap3(int size) {
    this.data = new LinkedList[size];
    this.size = size;
  }

  private int hash(K key) {
    return key.hashCode() % size;
  }

  private Optional<Cell> findCell(K key) {
    int index = hash(key);
    return Optional
      .ofNullable(data[index])
      .flatMap(ll ->
        ll.stream()
          .filter(c -> c.key.equals(key))
          .findFirst()
      );
  }

  public void put(K key, V value) {
    Optional<Cell> cell = findCell(key);
    // key is present, list is not null (2)
    cell.ifPresent(c -> c.value = value);

    int index = hash(key);
    if (data[index] == null) data[index] = new LinkedList<>();

    if (!cell.isPresent()) {
      data[index].addLast(new Cell(key, value));
    }
  }

  public V get(K key) {
    return findCell(key)
      .map(c -> c.value)
      .orElse(null);
  }

  enum Pizza {
    QuattroFormaggi,
    Pepperoni,
    Karbonara,
    Tomato,
    Margarita,
  }

  public static void main(String[] args) {
    HashMap3<Integer, Pizza> m = new HashMap3<>(100);
    m.put(135, Pizza.QuattroFormaggi);
    m.put(135, Pizza.Margarita);
    m.put(235, Pizza.Pepperoni);
//    m.put(335, Pizza.Karbonara);
    System.out.println(m.get(135));
    System.out.println(m.get(235));
//    System.out.println(m.get(335));
  }
}
