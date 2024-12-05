package nl.roka.adventofcode.aoc2024.day5;

public record Rule(int before, int after) {

  public static Rule of(String rule) {
    var split = rule.split("\\|");
    return Rule.of(split[0], split[1]);
  }

  private static Rule of(String before, String after) {
    return new Rule(Integer.parseInt(before), Integer.parseInt(after));
  }

  public int compare(int o1, int o2) {
    var result = o1 == before && o2 == after ? -1 : o1 == after && o2 == before ? 1 : 0;
    // System.out.printf("%s comparing %s vs %s == %s%n", this, o1, o2, result);
    return result;
  }
}
