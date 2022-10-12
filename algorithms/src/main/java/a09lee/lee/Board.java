package a09lee.lee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Board {

  private final static int[][] deltas = {{0,1}, {0,-1}, {1,0}, {-1,0}};
  private static final int OBSTACLE = -1;
  private static final int FREE = 0;

  private final int sizeX;
  private final int sizeY;
  private final int[][] board;

  public Board(int sizeX, int sizeY) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.board = new int[sizeY][sizeX];
  }

  void mark(int x, int y, int value) {
    board[y][x] = value;
  }

  void mark(Point pt, int value) {
    mark(pt.x, pt.y, value);
  }

  int at(int x, int y) {
    return board[y][x];
  }

  int at(Point pt) {
    return at(pt.x, pt.y);
  }

  boolean isFreeAt(int x, int y) {
    return at(x, y) == FREE;
  }

  boolean isFreeAt(Point pt) {
    return isFreeAt(pt.x, pt.y);
  }

  boolean isOnBoard(Point pt) {
    return pt.x >= 0 && pt.x < sizeX && pt.y >= 0 && pt.y < sizeY;
  }

  Stream<Point> neighbours(Point pt) {
    return Arrays.stream(deltas)
      .map(d -> Point.of(pt.x + d[0], pt.y + d[1]))
      .filter(this::isOnBoard);
  }

  Stream<Point> neighboursUnvisited(Point pt) {
    return neighbours(pt)
      .filter(this::isFreeAt);
  }

  boolean flood(List<Point> from, Point to, int value) {
    if (from.contains(to)) return true;
    List<Point> nextWave = from.stream().flatMap(f -> neighboursUnvisited(f))
      .peek(p -> mark(p, value))
      .collect(toList());
    if (nextWave.isEmpty()) return false;
    return flood(nextWave, to, value + 1);
  }

  // TODO
  Optional<List<Point>> backTrace() {
    return Optional.empty();
  }

  public Optional<List<Point>> path(Point from, Point to) {
    boolean found = flood(Arrays.asList(from), to, 1);
    if (!found) return Optional.empty();
    return backTrace();
  }
}
