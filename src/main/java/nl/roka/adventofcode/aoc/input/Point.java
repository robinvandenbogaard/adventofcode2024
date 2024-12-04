package nl.roka.adventofcode.aoc.input;

import java.util.List;

public record Point(int x, int y) {

  public static Point NORTH = new Point(0, 0).north();
  public static Point SOUTH = new Point(0, 0).south();
  public static Point WEST = new Point(0, 0).west();
  public static Point EAST = new Point(0, 0).east();
  public static Point NORTHEAST = new Point(0, 0).northEast();
  public static Point SOUTHWEST = new Point(0, 0).southWest();
  public static Point NORTHWEST = new Point(0, 0).northWest();
  public static Point SOUTHEAST = new Point(0, 0).southEast();

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

  public Point northEast() {
    return this.north().east();
  }

  public Point northWest() {
    return this.north().west();
  }

  public Point southEast() {
    return this.south().east();
  }

  public Point southWest() {
    return this.south().west();
  }

  public Point add(int x, int y) {
    return Point.of(this.x + x, this.y + y);
  }

  public Point add(Point point) {
    return Point.of(this.x + point.x, this.y + point.y);
  }
}
