package nl.roka.adventofcode.aoc2024.day5;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day5Test {

  @Test
  void silverExample() {
    assertThat(new Day5().runSilver()).isEqualTo(Answer.TBD);
  }

  @Test
  void goldExample() {
    assertThat(new Day5(LineReader.of("/day5-gold.in")).runGold()).isEqualTo(Answer.TBD);
  }
}
