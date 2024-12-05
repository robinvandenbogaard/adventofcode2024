package nl.roka.adventofcode.aoc2024.day5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day5Test {

  @Test
  void silverExample() {
    assertThat(new Day5().runSilver()).isEqualTo(Answer.of(143));
  }

  @Test
  void goldExample() {
    assertThat(new Day5(LineReader.of("/day5-gold.in")).runGold()).isEqualTo(Answer.TBD);
  }

  @Test
  void compareRuleLargerThan() {
    var comparator = RulesComparator.of(Rule.of("47|53"));
    assertThat(Stream.of(47, 53).sorted(comparator)).isEqualTo(List.of(47, 53));
  }

  @Test
  void compareRuleSmallerThan() {
    var comparator = RulesComparator.of(Rule.of("47|53"));
    assertThat(Stream.of(53, 47).sorted(comparator)).isEqualTo(List.of(47, 53));
  }

  @Test
  void compareRuleNoEqual() {
    var comparator = RulesComparator.of(Rule.of("47|53"));
    assertThat(Stream.of(47, 0).sorted(comparator)).isEqualTo(List.of(47, 0));
    assertThat(Stream.of(0, 53).sorted(comparator)).isEqualTo(List.of(0, 53));
  }

  public static Stream<Arguments> multiRuleInput() {
    return Stream.of(
        Arguments.of(List.of(47, 53, 66)),
        Arguments.of(List.of(47, 66, 53)),
        Arguments.of(List.of(53, 47, 66)),
        Arguments.of(List.of(53, 66, 47)),
        Arguments.of(List.of(66, 53, 47)),
        Arguments.of(List.of(66, 47, 53)));
  }

  @ParameterizedTest
  @MethodSource("multiRuleInput")
  void multiRule(List<Integer> digits) {
    var comparator = RulesComparator.of(List.of(Rule.of("47|53"), Rule.of("53|66")));

    var sorter = new Sorter(comparator, 5);

    assertThat(sorter.isSorted(digits, List.of(47, 53, 66))).isTrue();
  }

  @Test
  void inputLength() {
    List<Integer> evenSizedList = List.of(1, 2);
    assertThatThrownBy(() -> new Input(evenSizedList)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void centerValue() {
    List<Integer> input = List.of(1, 2, 3);
    assertThat(new Input(input).getCenterValue()).isEqualTo(2);
  }
}
