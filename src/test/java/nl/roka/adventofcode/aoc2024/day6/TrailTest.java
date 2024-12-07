package nl.roka.adventofcode.aoc2024.day6;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.input.Point;
import org.junit.jupiter.api.Test;

class TrailTest {
  @Test
  void hitsTrailAfter3Turns() {
    var t = new Trail(null);

    t.add(Point.of(0, 0));
    t.turn();
    t.add(Point.of(1, 0));
    t.turn();
    t.add(Point.of(1, 1));
    t.turn();
    t.add(Point.of(0, 1));
    assertThat(t.contains(Point.of(0, 0))).isTrue();
    t.turn();
    assertThat(t.contains(Point.of(0, 0))).isFalse();
  }
}
