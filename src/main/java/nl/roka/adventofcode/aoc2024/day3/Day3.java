package nl.roka.adventofcode.aoc2024.day3;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import nl.roka.adventofcode.aoc.input.Line;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day3 extends AbstractDayPuzzle {

  public static final Solutions SOLUTIONS = Solutions.none();

  public static Pattern mulPattern =
      Pattern.compile("mul\\(([0-9]{1,3},[0-9]{1,3})\\)", Pattern.MULTILINE);

  public static void main(String[] args) {
    Runner.run(new Day3());
  }

  public Day3() {
    super(new Day(3), SOLUTIONS);
  }

  public Day3(LineReader reader) {
    super(new Day(3, reader), SOLUTIONS);
  }

  @Override
  public Answer runSilver() {
    var full = day.stream().map(Line::text).collect(Collectors.joining());

    var sum = BigInteger.ZERO;
    var m = mulPattern.matcher(full);
    while (m.find()) {
      sum = sum.add(multiply(m.group(1)));
    }

    return Answer.of(sum);
  }

  private BigInteger multiply(String group) {
    return Arrays.stream(group.split(","))
        .map(BigInteger::new)
        .reduce(BigInteger.ONE, BigInteger::multiply);
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
