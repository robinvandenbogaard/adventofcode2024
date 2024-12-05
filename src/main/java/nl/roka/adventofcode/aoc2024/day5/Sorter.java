package nl.roka.adventofcode.aoc2024.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
  private final RulesComparator comparator;
  private final int passes;

  public Sorter(RulesComparator comparator, int passes) {
    this.comparator = comparator;
    this.passes = passes;
  }

  public boolean isSorted(List<Integer> digitsOrigin, List<Integer> expectedDigits) {
    var foundSorted = false;
    var digits = new ArrayList<>(digitsOrigin);
    for (int pass = 0; pass < passes && !foundSorted; pass++) {
      Collections.shuffle(digits);
      digits.sort(comparator);
      foundSorted = digits.equals(expectedDigits);

      if (foundSorted) System.out.printf("Needed %s passes.%n", pass);
    }

    return foundSorted;
  }
}
