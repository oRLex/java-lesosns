package a08graph;

import java.util.*;

public class XGraph {

  // vertex count
  public final int V;
  // links to
  private Set<Integer>[] links;

  public XGraph(int v) {
    this.V = v;
    this.links = new HashSet[v];
    for (int i = 0; i < V ; i++) {
      links[i] = new HashSet<>();
    }
  }

  public void add(int v1, int v2) {
    links[v1].add(v2);
  }

  public void remove(int v1, int v2) {
    links[v1].remove(v2);
  }

  public Set<Integer> children(int v) {
    return Collections.unmodifiableSet(links[v]);
  }

  public boolean path1(int v1, int v2, boolean[] visited) {
    if (visited[v1]) return false;
    visited[v1] = true;

    Set<Integer> children = children(v1);

    if (children.contains(v2)) return true;

    for (int c: children) {
      boolean found = path1(c, v2, visited);
      if (found) return true;
    }

    return false;
  }

  public boolean path1(int v1, int v2) {
    return path1(v1, v2, new boolean[V]);
  }

  public Optional<List<Integer>> path2(int v1, int v2, LinkedList<Integer> path, boolean[] visited) {
    if (visited[v1]) return Optional.empty();;
    visited[v1] = true;

    Set<Integer> children = children(v1);

    if (children.contains(v2)) {
      path.add(v2);
      return Optional.of(path);
    }

    for (int c: children) {
      path.add(c);
      Optional<List<Integer>> found = path2(c, v2, path, visited);
      if (found.isPresent()) return Optional.of(path);
      path.removeLast();
    }

    return Optional.empty();
  }

  public Optional<List<Integer>> path2(int v1, int v2) {
    LinkedList<Integer> path = new LinkedList<>();
    path.add(v1);
    return path2(v1, v2, path, new boolean[V]);
  }

  public List<Integer> dfs(int v) {
    boolean[] visited = new boolean[V];

    ArrayList<Integer> outcome = new ArrayList<>();

    LinkedList<Integer> process = new LinkedList<>();
    process.add(v);

    while (!process.isEmpty()) {
      int x = process.poll();

      if (visited[x]) continue;
      outcome.add(x);
      visited[x] = true;

      Set<Integer> chi = children(x);
      chi.forEach(process::addFirst);
    }

    return outcome;
  }

  public List<Integer> bfs(int v) {
    boolean[] visited = new boolean[V];

    ArrayList<Integer> outcome = new ArrayList<>();
    Queue<Integer> process = new LinkedList<>();
    process.add(v);

    while (!process.isEmpty()) {
      int x = process.poll();

      if (visited[x]) continue;
      outcome.add(x);
      visited[x] = true;

      Set<Integer> chi = children(x);
      chi.forEach(process::add);
    }

    return outcome;
  }
}
