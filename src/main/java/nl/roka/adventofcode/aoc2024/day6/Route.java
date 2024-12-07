package nl.roka.adventofcode.aoc2024.day6;

import java.util.ArrayList;
import java.util.List;
import nl.roka.adventofcode.aoc.input.Point;

public class Route {
  private final List<Point> positions = new ArrayList<>();

  public long distinctPositions() {
    return positions.stream().distinct().count();
  }

  public void add(Point position) {
    this.positions.add(position);
  }
}
