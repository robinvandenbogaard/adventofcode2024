package nl.roka.adventofcode.aoc2024.day5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day5Test {

  @Test
  void silverExample() {
    assertThat(new Day5().runSilver()).isEqualTo(Answer.of(143));
  }

  @Test
  void goldExample() {
    assertThat(new Day5(LineReader.of("/day5-gold.in")).runGold()).isEqualTo(Answer.of(123));
  }

  @Test
  void inputLength() {
    List<Integer> evenSizedList = List.of(1, 2);
    assertThatThrownBy(() -> new Input(evenSizedList, null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void centerValue() {
    List<Integer> input = List.of(1, 2, 3);
    assertThat(new Input(input, null).getCenterValue()).isEqualTo(2);
  }
}
