package nl.roka.adventofcode.aoc2024.day5;

import java.util.ArrayList;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day5 extends AbstractDayPuzzle {

  public static final Solutions SOLUTIONS = Solutions.silver(5452);
  private final ArrayList<Rule> rules;
  private final ArrayList<Input> inputs;

  public static void main(String[] args) {
    Runner.run(new Day5());
  }

  public Day5() {
    super(new Day(5), SOLUTIONS);
    rules = new ArrayList<>();
    inputs = new ArrayList<>();
  }

  public Day5(LineReader reader) {
    super(new Day(5, reader), SOLUTIONS);
    rules = new ArrayList<>();
    inputs = new ArrayList<>();
  }

  @Override
  public Answer runSilver() {
    readInput();

    var sum =
        inputs.stream().filter(Input::isSorted).map(Input::getCenterValue).reduce(0, Integer::sum);

    return Answer.of(sum);
  }

  private void readInput() {
    day.stream()
        .forEach(
            line -> {
              if (line.contains("|")) {
                rules.add(Rule.of(line.text()));
              } else if (line.contains(",")) {
                inputs.add(Input.of(line.text(), rules));
              }
            });
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
