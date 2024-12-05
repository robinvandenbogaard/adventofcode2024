package nl.roka.adventofcode.aoc2024.day5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public record RulesComparator(HashMap<Integer, Rule> rules) implements Comparator<Integer> {

  public static RulesComparator of(Rule rule) {
    return of(List.of(rule));
  }

  public static RulesComparator of(List<Rule> rules) {
    var rulesMap = new HashMap<Integer, Rule>();
    rules.forEach(
        r -> {
          rulesMap.put(r.before(), r);
          rulesMap.put(r.after(), r);
        });
    return new RulesComparator(rulesMap);
  }

  @Override
  public int compare(Integer o1, Integer o2) {
    var r1 = rules.get(o1);
    var r2 = rules.get(o2);
    if (r1 == null && r2 == null) return 0;

    if (r1 != null && r1.equals(r2)) {
      return r1.compare(o1, o2);
    }

    if (r2 != null && r2.equals(r1)) {
      return r2.compare(o1, o2);
    }

    if (r1 != null && r2 != null && !r1.equals(r2)) {
      return r1.compare(o1, o2) == 0 ? r2.compare(o1, o2) : r1.compare(o1, o2);
    }

    if (r1 != null && r2 == null) {
      return r1.compare(o1, o2);
    } else {
      return r2.compare(o1, o2);
    }
  }
}
