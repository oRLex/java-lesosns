package a01sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MergeAppTest {

  private final MergeApp ma = new MergeApp();

  @Test
  void merge1() {
    int[] a = {1,5,7,9};
    int[] b = {3,6,100,500};
    int[] fact = ma.merge(a, b);
    int[] expected = {1,3,5,6,7,9,100,500};
    assertArrayEquals(expected, fact);
  }

  @Test
  void merge2() {
    int[] a = {};
    int[] b = {3,6,100,500};
    int[] fact = ma.merge(a, b);
    int[] expected = {3,6,100,500};
    assertArrayEquals(expected, fact);
  }
}