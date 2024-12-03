package nl.roka.adventofcode.aoc2024.day3;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.MatchResult;
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

  public static final Solutions SOLUTIONS = Solutions.of(156388521, 75920122);

  public static Pattern mulPattern =
      Pattern.compile("do\\(\\)|mul\\(\\d{1,3},\\d{1,3}\\)|don't\\(\\)", Pattern.MULTILINE);

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
      if (m.group().startsWith("mul")) sum = sum.add(multiply(m.group()));
    }

    return Answer.of(sum);
  }

  private static BigInteger multiply(String group) {
    return Arrays.stream(getNumbersOnly(group).split(","))
        .map(BigInteger::new)
        .reduce(BigInteger.ONE, BigInteger::multiply);
  }

  @Override
  public Answer runGold() {
    var full = day.stream().map(Line::text).collect(Collectors.joining());

    var matches = mulPattern.matcher(full).results().map(MatchResult::group).toList();

    var sum = BigInteger.ZERO;
    var skip = false;
    for (var singleMatch : matches) {
      if (singleMatch.equals("don't()")) {
        skip = true;
      } else if (singleMatch.equals("do()")) {
        skip = false;
      }

      if (!skip && singleMatch.startsWith("mul")) {
        sum = sum.add(multiply(singleMatch));
      }
    }
    return Answer.of(sum);
  }

  private static String getNumbersOnly(String singelMatch) {
    return singelMatch.substring(4).substring(0, singelMatch.length() - 5);
  }
}
