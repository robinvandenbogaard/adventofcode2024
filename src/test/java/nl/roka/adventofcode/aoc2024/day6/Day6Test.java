package nl.roka.adventofcode.aoc2024.day6;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day6Test {

  @Test
  void silverExample() {
    assertThat(new Day6().runSilver()).isEqualTo(Answer.of(41));
  }

  @Test
  void goldExample() {
    assertThat(new Day6(LineReader.of("/day6-gold.in")).runGold()).isEqualTo(Answer.TBD);
  }
}
