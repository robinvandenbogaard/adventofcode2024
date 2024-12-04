package nl.roka.adventofcode.aoc2024.day4;

import static nl.roka.adventofcode.aoc.input.Point.*;
import static nl.roka.adventofcode.aoc.input.Point.NORTH;
import static nl.roka.adventofcode.aoc.input.Point.NORTHWEST;
import static nl.roka.adventofcode.aoc.input.Point.SOUTHEAST;

import nl.roka.adventofcode.aoc.input.Grid;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.input.Point;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day4 extends AbstractDayPuzzle {

  public static final Solutions SOLUTIONS = Solutions.silver(2642);
  private Grid grid;

  public static void main(String[] args) {
    Runner.run(new Day4());
  }

  public Day4() {
    super(new Day(4), SOLUTIONS);
  }

  public Day4(LineReader reader) {
    super(new Day(4, reader), SOLUTIONS);
  }

  @Override
  public Answer runSilver() {
    this.grid = day.fullGrid();
    return Answer.of(count("XMAS"));
  }

  private int count(String xmas) {
    var word = xmas.toCharArray();
    var total = 0;
    for (var x = 0; x < grid.width(); x++) {
      for (var y = 0; y < grid.height(); y++) {
        var letter = grid.getChar(x, y);
        if (letter == word[0]) {
          total += dfs(x, y, 0, word, NORTH) ? 1 : 0;
          total += dfs(x, y, 0, word, SOUTH) ? 1 : 0;
          total += dfs(x, y, 0, word, WEST) ? 1 : 0;
          total += dfs(x, y, 0, word, EAST) ? 1 : 0;
          total += dfs(x, y, 0, word, NORTHEAST) ? 1 : 0;
          total += dfs(x, y, 0, word, SOUTHWEST) ? 1 : 0;
          total += dfs(x, y, 0, word, NORTHWEST) ? 1 : 0;
          total += dfs(x, y, 0, word, SOUTHEAST) ? 1 : 0;
        }
      }
    }
    return total;
  }

  private boolean dfs(int x, int y, int index, char[] word, Point dir) {
    var point = of(x, y);
    if (word.length == index) return true;

    if (!grid.inBounds(x, y)) return false;

    var letter = grid.getChar(point);
    if (letter != word[index]) return false;

    grid.set(point, "#"); // visited

    if (dfs(point.add(dir).x(), point.add(dir).y(), index + 1, word, dir)) {
      grid.set(point, "" + letter); // reset visited
      return true;
    }

    grid.set(point, "" + letter); // reset visited

    return false;
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
