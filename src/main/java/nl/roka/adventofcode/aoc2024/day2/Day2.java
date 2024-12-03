package nl.roka.adventofcode.aoc2024.day2;

import java.util.List;
import java.util.function.BiFunction;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day2 extends AbstractDayPuzzle {

  public static final Solutions SOLUTIONS = Solutions.silver(314);

  public static void main(String[] args) {
    Runner.run(new Day2());
  }

  public Day2() {
    super(new Day(2), SOLUTIONS);
  }

  public Day2(LineReader reader) {
    super(new Day(2, reader), SOLUTIONS);
  }

  @Override
  public Answer runSilver() {
    return Answer.of(day.map(line -> line.toIntegers(" ")).filter(this::isSafe).count());
  }

  public boolean isSafe(List<Integer> reading) {
    if (reading.isEmpty()) return true;
    var cursor = new Cursor(reading, 0);
    var violation = false;

    for (int i = 1; i < reading.size() && !violation; i++) {
      cursor.peekAt(i);
      if (cursor.violatesGrowth()) violation = true;
      if (cursor.violatesDifference()) violation = true;
      cursor.advance();
    }
    return !violation;
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
