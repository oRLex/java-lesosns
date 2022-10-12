package a09lee;

import java.util.List;

public interface Board {
  boolean isGameOver();
  List<Point> getStones();
  List<Point> getApples();
  Point getHead();
  List<Point> getSnake();
  List<Point> getWalls();
  List<Point> getBarriers();
  Elements getAt(Point pt);
}
