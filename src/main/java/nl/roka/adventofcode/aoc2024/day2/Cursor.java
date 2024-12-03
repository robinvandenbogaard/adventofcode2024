package nl.roka.adventofcode.aoc2024.day2;

import java.util.List;
import java.util.function.BiFunction;

class Cursor {

  private final List<Integer> reading;
  private int cursorPosition;
  private int peekPosition;
  private BiFunction<Integer, Integer, Boolean> comparator;

  public Cursor(List<Integer> reading, Integer cursorPosition) {
    this.reading = reading;
    this.cursorPosition = cursorPosition;
    this.comparator = null;
  }

  public void peekAt(int position) {
    peekPosition = position;
    if (comparator == null) {
      comparator = getComparator(current(), peek());
    }
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

  private BiFunction<Integer, Integer, Boolean> getComparator(Integer curr, Integer other) {
    return curr < other ? (a, b) -> a < b : (a, b) -> a > b;
  }

  public boolean violatesGrowth() {
    return !comparator.apply(current(), peek());
  }

  public boolean violatesDifference() {
    return Math.abs(current() - peek()) > 3;
  }

  public void advance() {
    cursorPosition = peekPosition;
  }
}
