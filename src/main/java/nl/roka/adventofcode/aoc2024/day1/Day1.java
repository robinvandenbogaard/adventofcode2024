package nl.roka.adventofcode.aoc2024.day1;

import java.math.BigInteger;
import java.util.ArrayList;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day1 extends AbstractDayPuzzle {

  public static final Solutions SOLUTIONS = Solutions.of(2113135, 19097157);

  public static void main(String[] args) {
    Runner.run(new Day1());
  }

  public Day1() {
    super(new Day(1), SOLUTIONS);
  }

  public Day1(LineReader reader) {
    super(new Day(1, reader), SOLUTIONS);
  }

  @Override
  public Answer runSilver() {
    var list1 = new ArrayList<Integer>();
    var list2 = new ArrayList<Integer>();
    day.forEach(
        line -> {
          var split = line.split(" {3}");
          list1.add(Integer.parseInt(split[0]));
          list2.add(Integer.parseInt(split[1]));
        });

    list1.sort(Integer::compareTo);
    list2.sort(Integer::compareTo);

    int sum = 0;
    for (int i = 0; i < list1.size(); i++) {
      sum += Math.abs(list1.get(i) - list2.get(i));
    }

    return Answer.of(sum);
  }

  @Override
  public Answer runGold() {
    var list1 = new ArrayList<BigInteger>();
    var list2 = new ArrayList<BigInteger>();
    day.forEach(
        line -> {
          var split = line.split(" {3}");
          list1.add(new BigInteger(split[0]));
          list2.add(new BigInteger(split[1]));
        });

    BigInteger sum = BigInteger.ZERO;
    for (BigInteger id1 : list1) {
      sum =
          sum.add(
              id1.multiply(
                  BigInteger.valueOf(list2.stream().filter(id -> id.equals(id1)).count())));
    }

    return Answer.of(sum);
  }
}
