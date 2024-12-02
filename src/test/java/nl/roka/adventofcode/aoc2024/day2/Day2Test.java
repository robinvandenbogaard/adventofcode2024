package nl.roka.adventofcode.aoc2024.day2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day2Test {
  @Test
  void silverExample() {
    assertThat(new Day2().runSilver()).isEqualTo(Answer.of("2"));
  }

  @Test
  void goldExample() {
    assertThat(new Day2(LineReader.of("/day1-gold.in")).runGold()).isEqualTo(Answer.of("TBD"));
  }

  @Test
  void isSafe() {
    var day = new Day2();

    // order
    assertThat(day.isSafe(List.of())).isTrue();
    assertThat(day.isSafe(List.of(1, 2))).isTrue();
    assertThat(day.isSafe(List.of(-1, 2))).isTrue();
    assertThat(day.isSafe(List.of(1, 1))).isFalse();
    assertThat(day.isSafe(List.of(1, 3, 2))).isFalse();
    assertThat(day.isSafe(List.of(1, 2, 3, 4, 5, 7))).isTrue();
    assertThat(day.isSafe(List.of(1, 2, 3, 3, 4, 5, 7))).isFalse();
    assertThat(day.isSafe(List.of(1, 2, 3, 4, 5, 7).reversed())).isTrue();
    assertThat(day.isSafe(List.of(1, 2, 9, 3, 4, 5, 7))).isFalse();

    // beat skip
    assertThat(day.isSafe(List.of(1, 4))).isTrue();
    assertThat(day.isSafe(List.of(1, 5))).isFalse();
    assertThat(day.isSafe(List.of(0, 4))).isFalse();
    assertThat(day.isSafe(List.of(1, 4).reversed())).isTrue();
    assertThat(day.isSafe(List.of(1, 5).reversed())).isFalse();
    assertThat(day.isSafe(List.of(0, 4).reversed())).isFalse();
  }
}
