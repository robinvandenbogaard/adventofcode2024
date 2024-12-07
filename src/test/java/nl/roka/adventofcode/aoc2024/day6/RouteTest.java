package nl.roka.adventofcode.aoc2024.day6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import nl.roka.adventofcode.aoc.input.Point;
import org.junit.jupiter.api.Test;

class RouteTest {

  @Test
  void distinctCount() {
    var r = new Route();

    r.add(Point.NORTH);
    r.add(Point.NORTH);
    r.add(Point.NORTH);
    assertThat(r.distinctPositions()).isEqualTo(1);
    r.add(Point.NORTH);
    r.add(Point.ZERO);
    r.add(Point.ZERO);
    assertThat(r.distinctPositions()).isEqualTo(2);
    r.add(Point.EAST);
    r.add(Point.WEST);
    assertThat(r.distinctPositions()).isEqualTo(4);
  }
}
