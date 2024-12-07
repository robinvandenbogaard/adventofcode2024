package nl.roka.adventofcode.aoc2024.day6;

import java.util.ArrayList;
import java.util.List;
import nl.roka.adventofcode.aoc.input.Grid;
import nl.roka.adventofcode.aoc.input.Point;

public class Route {
  private final List<Point> positions = new ArrayList<>();
  private final Trail trail;

  public Route(Grid grid) {
    trail = new Trail(grid);
  }

  public long distinctPositions() {
    return positions.stream().distinct().count();
  }

  public void add(Point position) {
    this.positions.add(position);
    this.trail.add(position);
  }

  public boolean isOnTrail(Point position) {
    return trail.contains(position);
  }

  public void updateTrail() {
    trail.turn();
  }
}
