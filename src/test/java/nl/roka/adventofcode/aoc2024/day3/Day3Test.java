package nl.roka.adventofcode.aoc2024.day3;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day3Test {

  @Test
  void silverExample() {
    assertThat(new Day3().runSilver()).isEqualTo(Answer.of("161"));
  }

  @Test
  void goldExample() {
    assertThat(new Day3(LineReader.of("/day3-gold.in")).runGold()).isEqualTo(Answer.of("TBD"));
  }

  @ParameterizedTest
  @ValueSource(strings = {"mul(0,0)", "mul(999,999)"})
  void matches(String input) {
    assertThat(Day3.mulPattern.matcher(input).matches()).isTrue();
  }
}
