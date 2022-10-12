package a05binarysearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchAppTest {

  BinarySearchApp bs = new BinarySearchApp();

  @Test
  void containsFalse() {
    int[] data = bs.data();
    assertFalse(
      bs.contains(
        data,
        999
      )
    );
  }

  @Test
  void containsTrue() {
    int[] data = bs.data();
    assertTrue(
      bs.contains(
        data,
        data[(int) (Math.random()*data.length)]
      )
    );
  }

  @Test
  void indexOfNone() {
    int[] data = bs.data();
    assertEquals(
      Optional.empty(),
      bs.indexOf(
        data,
        999
      )
    );
  }

  @Test
  void IndexOfSome() {
    int[] data = bs.data();
    int idx = (int) (Math.random()*data.length);
    assertEquals(
      Optional.of(idx),
      bs.indexOf(
        data,
        data[idx]
      )
    );
  }

  @Test
  void IndexOfSome0() {
    int[] data = bs.data();
    int idx = 0;
    System.out.println(Arrays.toString(data));
    assertEquals(
      Optional.of(idx),
      bs.indexOf(
        data,
        data[idx]
      )
    );
  }

  @Test
  void index3NotFoundAt() {
    int[] data = bs.data();
    int idx = data.length - 1; // index of last

    assertEquals(
      SResult.insertAt(data.length),

      bs.indexOf3(
        data,
        data[idx] + 100
      )
    );
  }

  @Test
  void index3FoundAt() {
    int[] data = bs.data();
    int idx = 5;

    assertEquals(
      SResult.foundAt(idx),

      bs.indexOf3(
        data,
        data[idx]
      )
    );
  }


}