package nl.roka.adventofcode.aoc2024.day6;

import nl.roka.adventofcode.aoc.input.Grid;
import nl.roka.adventofcode.aoc.input.Point;

class Guard {
  private final Route route;
  private final Grid grid;
  private Point position;
  private Point direction;

  public Guard(Point start, Grid grid) {
    this.grid = grid;
    this.route = new Route();
    route.add(start);
    this.position = start;
    this.direction = Point.NORTH;
  }

  public Route patrol() {
    while (grid.inBounds(position.add(direction))) {
      if (obstructed()) {
        direction = direction.turnRight();
      }
      advance();
      // grid.print();
      // System.out.println();
    }
    return route;
  }

  private boolean obstructed() {
    return grid.get(position.add(direction)).equals("#");
  }

  private void advance() {
    // grid.set(position, ".");
    position = position.add(direction);
    // grid.set(position, "G");
    route.add(position);
  }
}
