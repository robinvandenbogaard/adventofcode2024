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
    var curr = reading.getFirst();
    var violation = false;

    BiFunction<Integer, Integer, Boolean> comparator = null;

    for (int i = 1; i < reading.size() && !violation; i++) {
      Integer other = reading.get(i);
      if (comparator == null) {
        comparator = getComparator(curr, other);
      }

      if (!comparator.apply(curr, other)) violation = true;

      if (Math.abs(other - curr) > 3) violation = true;

      curr = other;
    }
    return !violation;
  }

  private BiFunction<Integer, Integer, Boolean> getComparator(Integer curr, Integer other) {
    return curr < other ? (a, b) -> a < b : (a, b) -> a > b;
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
