package nl.roka.adventofcode.aoc2024.day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph<V> {
  private final HashMap<V, List<V>> graph;

  public Graph() {
    graph = new HashMap<>();
  }

  void add(V vertex, V edge) {
    graph.computeIfAbsent(vertex, k -> new ArrayList<>()).add(edge);
    graph.computeIfAbsent(edge, k -> new ArrayList<>());
  }

  public boolean isSorted(List<V> digits) {
    var sorted = true;
    for (int i = 1; i < digits.size() && sorted; i++) {
      sorted = canReach(digits.get(i - 1), digits.subList(i, digits.size()));
    }
    return sorted;
  }

  public boolean canReach(V start, List<V> targets) {
    var visited = new ArrayList<V>();
    dfs(start, visited);
    return visited.containsAll(targets);
  }

  private void dfs(V node, List<V> visited) {
    visited.add(node);
    for (V next : graph.get(node)) {
      if (!visited.contains(next)) {
        dfs(next, visited);
      }
    }
  }
}
