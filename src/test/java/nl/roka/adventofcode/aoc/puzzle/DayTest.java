package nl.roka.adventofcode.aoc.puzzle;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class DayTest {
  @Test
  void forEachReadsAll() {
    var day1 = new Day(1);
    var result = new ArrayList<String>();
    day1.forEach(result::add);
    assertThat(result).containsExactly("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet");
  }
}
