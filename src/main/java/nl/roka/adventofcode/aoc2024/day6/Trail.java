package nl.roka.adventofcode.aoc2024.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nl.roka.adventofcode.aoc.input.Grid;
import nl.roka.adventofcode.aoc.input.Point;

public class Trail {

  private final HashMap<Integer, List<Point>> trail = new HashMap<>();
  private final Grid grid;
  private int current = 0;

  public Trail(Grid grid) {
    this.grid = grid;
  }

  public void add(Point position) {
    getCurrent().add(position);
  }

  public boolean contains(Point position) {
    return trail.entrySet().stream().anyMatch(entry -> entry.getValue().contains(position));
  }

  public void turn() {
    if (current < 3) {
      current++;
    } else {
      current = 0;
    }
    clear();
  }

  private void clear() {
    if (Day6.DEBUG && grid != null) getCurrent().forEach(p -> grid.set(p, "."));
    getCurrent().clear();
  }

  private List<Point> getCurrent() {
    return trail.computeIfAbsent(current, k -> new ArrayList<>());
  }
}
