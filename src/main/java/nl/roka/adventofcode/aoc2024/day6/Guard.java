package nl.roka.adventofcode.aoc2024.day6;

import nl.roka.adventofcode.aoc.input.Grid;
import nl.roka.adventofcode.aoc.input.Point;

class Guard {
  private final Route route;
  private final Grid grid;
  private Point position;
  private Point direction;
  private int couldBeObstructions;
  private boolean obstructionsChanged;

  public Guard(Point start, Grid grid) {
    this.grid = grid;
    this.route = new Route(grid);
    route.add(start);
    this.position = start;
    this.direction = Point.NORTH;
  }

  public Route patrol() {
    while (grid.inBounds(position.add(direction))) {
      if (obstructed()) {
        direction = direction.turnRight();
        route.updateTrail();
      }

      if (route.isOnTrail(position.add(direction))) {
        couldBeObstructions++;
        obstructionsChanged = true;
      }

      advance();
      print();
      obstructionsChanged = false;
    }
    return route;
  }

  private void print() {
    if (Day6.DEBUG) {
      grid.print();
      System.out.println();
    }
  }

  private boolean obstructed() {
    return grid.get(position.add(direction)).equals("#");
  }

  private void advance() {
    if (Day6.DEBUG) grid.set(position, route.isOnTrail(position) ? "*" : ".");
    position = position.add(direction);
    if (Day6.DEBUG) grid.set(position, obstructionsChanged ? "X" : "G");
    route.add(position);
  }

  public int getCouldBeObstructions() {
    return couldBeObstructions;
  }
}
