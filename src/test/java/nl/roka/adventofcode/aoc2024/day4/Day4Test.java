package nl.roka.adventofcode.aoc2024.day4;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day4Test {

  @Test
  void silverExample() {
    assertThat(new Day4().runSilver()).isEqualTo(Answer.TBD);
  }

  @Test
  void goldExample() {
    assertThat(new Day4(LineReader.of("/day4-gold.in")).runGold()).isEqualTo(Answer.TBD);
  }
}
