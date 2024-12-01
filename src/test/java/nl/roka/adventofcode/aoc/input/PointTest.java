package nl.roka.adventofcode.aoc.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void adjecent() {
    assertThat(Point.of(0, 0).adjecent())
        .containsExactlyInAnyOrder(
            Point.of(-1, -1),
            Point.of(0, -1),
            Point.of(1, -1),
            Point.of(-1, 0),
            Point.of(1, 0),
            Point.of(-1, 1),
            Point.of(0, 1),
            Point.of(1, 1));
  }
}
