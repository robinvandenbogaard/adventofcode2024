package nl.roka.adventofcode.aoc2024.day2;

import java.util.List;
import java.util.function.BiFunction;

class Cursor {

  private final List<Integer> reading;
  private BiFunction<Integer, Integer, Boolean> comparator;
  private int cursorPosition;
  private int peekPosition;
  private int violations = 0;
  private boolean violationsChanged = false;
  private boolean doNotSkip = true;

  public Cursor(List<Integer> reading, Integer cursorPosition) {
    this.reading = reading;
    this.cursorPosition = cursorPosition;
    this.comparator = null;
  }

  public Cursor allowSkip() {
    doNotSkip = false;
    return this;
  }

  public void peekAt(int position) {
    peekPosition = position;
    if (comparator == null) {
      comparator = getComparator(current(), peek());
    }
    violatesGrowth();
    violatesDifference();
  }

  public void advance() {
    if (doNotSkip || !violationsChanged) cursorPosition = peekPosition;
    violationsChanged = false;
  }

  public int countViolations() {
    return violations;
  }

  private Integer current() {
    return read(cursorPosition);
  }

  private Integer peek() {
    return read(peekPosition);
  }

  private Integer read(int position) {
    return reading.get(position);
  }

  private void violatesGrowth() {
    if (!comparator.apply(current(), peek())) setViolations(violations + 1);
  }

  private void violatesDifference() {
    if (Math.abs(current() - peek()) > 3) setViolations(violations + 1);
  }

  private void setViolations(int violations) {
    this.violations = violations;
    this.violationsChanged = true;
  }

  private static BiFunction<Integer, Integer, Boolean> getComparator(Integer curr, Integer other) {
    return curr < other ? (a, b) -> a < b : (a, b) -> a > b;
  }
}
