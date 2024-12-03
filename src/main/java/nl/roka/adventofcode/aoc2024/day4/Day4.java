package nl.roka.adventofcode.aoc2024.day4;

import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day4 extends AbstractDayPuzzle {

  public static final Solutions SOLUTIONS = Solutions.none();

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
    return Answer.TBD;
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
