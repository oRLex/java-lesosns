package a09lee;

import java.util.List;

public class YourSolver implements Solver<Board> {

    private Direction solve(Point apple, Point head) {
        if      (apple.x() < head.x()) return Direction.LEFT;
        else if (apple.x() > head.x()) return Direction.RIGHT;
        else if (apple.y() < head.y()) return Direction.UP;
        else                           return Direction.DOWN;
    }

    private String explore(Board board) {
        if (board.isGameOver()) {
            return Direction.UP.toString();
        }
        Point redStone = board.getStones().get(0);
        Point greenApple = board.getApples().get(0);
        Point snakeHead = board.getHead();
        List<Point> snake = board.getSnake();
        List<Point> walls = board.getWalls();
        List<Point> barriers = board.getBarriers(); // snake + stone + walls
        Elements at = board.getAt(PointImpl.pt(5, 5));

        throw new IllegalArgumentException("not implemented");
    }

    @Override
    public String get(Board board) {
        System.out.println(board.toString());
        return Direction.UP.toString();
    }

    public static void main(String[] args) {
        final String address = "http://167.99.241.128/codenjoy-contest/board/player/kd0pkqph6ju8xgpzj3l6?code=450802955821598951";
        final YourSolver solver = new YourSolver();
        final Board board = null;

        WebSocketRunner.runClient(address, solver, board);
    }

}
