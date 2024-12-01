package nl.roka.adventofcode.aoc2024.day1;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day1Test {

  @Test
  void silverExample() {
    assertThat(new Day1().runSilver()).isEqualTo(Answer.of("11"));
  }

  @Test
  void goldExample() {
    assertThat(new Day1(LineReader.of("/day1-gold.in")).runGold()).isEqualTo(Answer.TBD);
  }
}
