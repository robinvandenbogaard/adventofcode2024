package nl.roka.adventofcode.aoc2024.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public record Input(List<Integer> digits, Graph<Integer> graph) {
  public Input {
    if (digits.size() % 2 == 0) throw new IllegalArgumentException("digits must be uneven");
  }

  public static Input of(String digitList, ArrayList<Rule> rules) {
    var digits = Arrays.stream(digitList.split(",")).map(Integer::valueOf).toList();
    var graph = new Graph<Integer>();
    rules.stream()
        .filter(r -> digits.contains(r.before()) && digits.contains(r.after()))
        .forEach(r -> graph.add(r.before(), r.after()));
    return new Input(digits, graph);
  }

  public int getCenterValue() {
    return digits.get(digits.size() / 2);
  }

  public boolean isSorted() {
    return graph.isSorted(digits);
  }

  public boolean isNotSorted() {
    return !isSorted();
  }

  public Input sorted() {
    var topo = graph.topologicalNodeOrder();
    var sorted = new ArrayList<>(digits);
    sorted.sort(Comparator.comparing(topo::indexOf));
    return new Input(sorted, graph);
  }
}
