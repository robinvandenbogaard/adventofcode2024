package nl.roka.adventofcode.aoc2024.day5;

import java.util.ArrayList;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day5 extends AbstractDayPuzzle {

  public static final Solutions SOLUTIONS = Solutions.none();

  public static void main(String[] args) {
    Runner.run(new Day5());
  }

  public Day5() {
    super(new Day(5), SOLUTIONS);
  }

  public Day5(LineReader reader) {
    super(new Day(5, reader), SOLUTIONS);
  }

  @Override
  public Answer runSilver() {
    var rules = new ArrayList<Rule>();
    var input = new ArrayList<Input>();

    day.stream()
        .forEach(
            line -> {
              if (line.contains("|")) {
                rules.add(Rule.of(line.text()));
              } else if (line.contains(",")) {
                input.add(Input.of(line.text()));
              }
            });

    var sorter = new Sorter(RulesComparator.of(rules), 5);

    var sum =
        input.stream()
            .filter(line -> sorter.isSorted(line.digits(), line.digits()))
            .map(Input::getCenterValue)
            .reduce(Integer::sum)
            .orElse(0);

    return Answer.of(sum);
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
