package a08graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class GraphApp {

  XGraph g = new XGraph(5) {{
    add(0, 1);
    add(1, 2);
    add(1, 3);
    add(2, 3);
    add(4, 3);
    add(3, 1);
  }};

  @Test
  public void test1() {
    assertTrue(g.path1(0, 1));
  }

  @Test
  public void test2() {
    assertTrue(g.path1(1, 2));
  }

  @Test
  public void test3() {
    assertTrue(g.path1(0, 3));
  }

  @Test
  public void test4() {
    assertFalse(g.path1(3, 4));
  }

  @Test
  public void test11() {
    assertEquals(Optional.of(Arrays.asList(0, 1)), g.path2(0, 1));
  }

  @Test
  public void test12() {
    assertEquals(Optional.of(Arrays.asList(1, 2)), g.path2(1, 2));
  }

  @Test
  public void test13() {
    Optional<List<Integer>> path1 = Optional.of(Arrays.asList(0, 1, 2, 3));
    Optional<List<Integer>> path2 = Optional.of(Arrays.asList(0, 1, 3));
    Optional<List<Integer>> real = g.path2(0, 3);
    System.out.println(real);
    assertTrue(
      real.equals(path1) || real.equals(path2)
    );
  }

  @Test
  public void test14() {
    assertEquals(Optional.empty(), g.path2(3, 4));
  }

  @Test
  public void test15() {
    assertEquals(Optional.empty(), g.path2(0, 4));
  }

  @Test
  public void bfs1() {
    List<Integer> path1 = Arrays.asList(0, 1, 2, 3);
    List<Integer> path2 = Arrays.asList(0, 1, 3, 2);
    List<Integer> real = g.bfs(0);
    System.out.println(real);
    assertTrue(
      real.equals(path1) || real.equals(path2)
    );
  }

  @Test
  public void dfs1() {
    List<Integer> path1 = Arrays.asList(0, 1, 2, 3);
    List<Integer> path2 = Arrays.asList(0, 1, 3, 2);
    List<Integer> real = g.dfs(0);
    assertTrue(
      real.equals(path1) || real.equals(path2)
    );
  }

}
