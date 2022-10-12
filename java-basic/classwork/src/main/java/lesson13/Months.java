package lesson13;

import java.util.Iterator;

public class Months implements Iterable<String> {

  private static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

  @Override
  public Iterator<String> iterator() {
    return new Iterator<String>() {

      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < months.length;
      }

      @Override
      public String next() {
        return months[index++];
      }
    };
  }

  public Iterator<String> reverseIterator() {
    return new Iterator<String>() {

      private int index = months.length - 1;

      @Override
      public boolean hasNext() {
        return index >= 0;
      }

      @Override
      public String next() {
        return months[index--];
      }
    };
  }

  public Iterator<String> randomIterator() {
    return new Iterator<String>() {

      int count = 0;
      boolean[] visited = new boolean[months.length];

      private void markVisited(int n) {
        visited[n] = true;
        count++;
      }

      private int index() {
        int i = (int) (Math.random() * 12);

        while (visited[i])
          i = (i + 1) % 12;

        markVisited(i);
        return i;
      }

      @Override
      public boolean hasNext() {
        return count < 12;
      }

      @Override
      public String next() {
        return months[index()];
      }
    };
  }
}
