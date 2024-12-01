package nl.roka.adventofcode.aoc.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GridTest {
  @Test
  void gridCreation() {
    Grid grid = Grid.of(LineReader.of("/aoc/gridTest.in"));

    assertThat(grid.get(0, 0)).isEqualTo("1");
    assertThat(grid.get(0, 1)).isEqualTo("2");
    assertThat(grid.get(0, 2)).isEqualTo("3");

    assertThat(grid.get(1, 0)).isEqualTo("a");
    assertThat(grid.get(1, 1)).isEqualTo("b");
    assertThat(grid.get(1, 2)).isEqualTo("c");
  }

  @Test
  void outOfBounds() {
    Grid grid = Grid.of(LineReader.of("/aoc/gridTest.in"));

    assertThat(grid.get(-1, 0)).isNull();
    assertThat(grid.get(3, 0)).isNull();
    assertThat(grid.get(1, -1)).isNull();
    assertThat(grid.get(1, 3)).isNull();
  }

  @Test
  void symbol() {
    Grid grid = Grid.of(LineReader.of("/aoc/gridTest.in"));

    assertThat(grid.findSymbol("b")).isEqualTo(Point.of(1, 1));
  }

  @Test
  void directional() {
    Grid grid = Grid.of(LineReader.of("/aoc/gridTest.in"));
    Point point_b = grid.findSymbol("b");

    assertThat(grid.get(point_b.north())).isEqualTo("2");
    assertThat(grid.get(point_b.south())).isEqualTo("#");
    assertThat(grid.get(point_b.west())).isEqualTo("a");
    assertThat(grid.get(point_b.east())).isEqualTo("c");
  }

  @Test
  void setSymbol() {
    Grid grid = Grid.of(LineReader.of("/aoc/gridTest.in"));

    grid.set(Point.of(2, 0), "*");

    assertThat(grid.get(Point.of(2, 0))).isEqualTo("*");
  }
}
