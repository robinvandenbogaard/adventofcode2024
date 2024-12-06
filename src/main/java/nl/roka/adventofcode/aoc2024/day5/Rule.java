package nl.roka.adventofcode.aoc2024.day5;

public record Rule(int before, int after) {

  public static Rule of(String rule) {
    var split = rule.split("\\|");
    return Rule.of(split[0], split[1]);
  }

  private static Rule of(String before, String after) {
    return new Rule(Integer.parseInt(before), Integer.parseInt(after));
  }
}
