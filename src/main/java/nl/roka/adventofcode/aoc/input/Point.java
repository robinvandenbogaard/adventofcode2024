package nl.roka.adventofcode.aoc.input;

import java.util.List;

public record Point(int x, int y) {
  public static Point of(int x, int y) {
    return new Point(x, y);
  }

  public List<Point> adjecent() {
    return List.of(
        Point.of(x - 1, y - 1),
        Point.of(x, y - 1),
        Point.of(x + 1, y - 1),
        Point.of(x - 1, y),
        Point.of(x + 1, y),
        Point.of(x - 1, y + 1),
        Point.of(x, y + 1),
        Point.of(x + 1, y + 1));
  }

  public Point setY(int y) {
    return Point.of(x, y);
  }

  public Point north() {
    return this.add(-1, 0);
  }

  public Point south() {
    return this.add(1, 0);
  }

  public Point east() {
    return this.add(0, 1);
  }

  public Point west() {
    return this.add(0, -1);
  }

  public Point add(int x, int y) {
    return Point.of(this.x + x, this.y + y);
  }
}
