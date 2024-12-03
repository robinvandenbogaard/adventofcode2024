package nl.roka.adventofcode.aoc2024.day2;

import java.util.List;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day2 extends AbstractDayPuzzle {

  public static final Solutions SOLUTIONS = Solutions.of(314, 373);

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

    for (int i = 1; i < reading.size(); i++) {
      cursor.peekAt(i);
      cursor.advance();
    }
    return cursor.countViolations() == 0;
  }

  @Override
  public Answer runGold() {
    return Answer.of(day.map(line -> line.toIntegers(" ")).filter(this::isSafeWithSkip).count());
  }

  public boolean isSafeWithSkip(List<Integer> reading) {
    if (reading.isEmpty()) return true;
    var cursor1 = new Cursor(reading, 0).allowSkip();
    var cursor2 = new Cursor(reading, reading.size() - 1).allowSkip();

    for (int i = 1, j = reading.size() - 2; i < reading.size(); i++, j--) {
      cursor1.peekAt(i);
      cursor2.peekAt(j);
      cursor1.advance();
      cursor2.advance();
    }
    return cursor1.countViolations() < 2 || cursor2.countViolations() < 2;
  }
}
