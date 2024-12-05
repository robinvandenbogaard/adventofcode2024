package nl.roka.adventofcode.aoc2024.day5;

import java.util.Arrays;
import java.util.List;

public record Input(List<Integer> digits) {
  public Input {
    if (digits.size() % 2 == 0) throw new IllegalArgumentException("digits must be uneven");
  }

  public static Input of(String digitList) {
    return new Input(Arrays.stream(digitList.split(",")).map(Integer::valueOf).toList());
  }

  public int getCenterValue() {
    return digits.get(digits.size() / 2);
  }
}
