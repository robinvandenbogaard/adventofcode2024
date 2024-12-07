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

  @Test
  void sortError1() {
    var day = new Day5();
    day.readInput();
    assertThat(Input.of("75,97,47,61,53", day.rules).sorted().digits())
        .containsExactly(97, 75, 47, 61, 53);
  }

  @Test
  void sortError2() {
    var day = new Day5();
    day.readInput();
    assertThat(Input.of("61,13,29", day.rules).sorted().digits()).containsExactly(61, 29, 13);
  }

  @Test
  void sortError3() {
    var day = new Day5();
    day.readInput();
    assertThat(Input.of("97,13,75,29,47", day.rules).sorted().digits())
        .containsExactly(97, 75, 47, 29, 13);
  }
}
