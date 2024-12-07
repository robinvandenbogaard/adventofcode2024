package nl.roka.adventofcode.aoc2024.day6;

import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day6 extends AbstractDayPuzzle {

  public static final Solutions SOLUTIONS = Solutions.silver(4890);

  public static void main(String[] args) {
    Runner.run(new Day6());
  }

  public Day6() {
    super(new Day(6), SOLUTIONS);
  }

  public Day6(LineReader reader) {
    super(new Day(6, reader), SOLUTIONS);
  }

  @Override
  public Answer runSilver() {
    var grid = day.fullGrid();
    var start = grid.findSymbol("^");
    var route = new Guard(start, grid).patrol();
    return Answer.of(route.distinctPositions());
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
