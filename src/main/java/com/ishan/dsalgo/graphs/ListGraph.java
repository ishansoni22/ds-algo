package com.ishan.dsalgo.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ListGraph<T> {

  private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  private ArrayList<T> vertexSpace = new ArrayList<>();
  private Map<T, Integer> mappingTable = new HashMap<>();

  public ListGraph() {
  }

  public void addVertex(T vertex) {
    int insertIdx = vertexSpace.size();
    vertexSpace.add(vertex);
    graph.add(new ArrayList<>());
    mappingTable.put(vertex, insertIdx);
  }

  public void addEdge(T t1, T t2) {
    Integer vIdx1 = mappingTable.get(t1);
    Integer vIdx2 = mappingTable.get(t2);
    graph.get(vIdx1).add(vIdx2);
  }

  public void breathFirstTraversal() {
    int islands = 0;
    Set<T> discovered = new HashSet<>();
    for (T node : vertexSpace) {
      if (!discovered.contains(node)) {
        ++islands;
        bfsSubGraph(graph, discovered, node);
        System.out.println("-----");
      }
    }
    System.out.println("No of connected components = " + islands);
  }

  private void bfsSubGraph(ArrayList<ArrayList<Integer>> graph,
      Set<T> discovered, T source) {
    Queue<T> q = new ArrayDeque<>();
    q.add(source);
    discovered.add(source);

    while (!q.isEmpty()) {
      T item = q.poll();
      System.out.println(item);
      Integer iIdx = mappingTable.get(item);
      ArrayList<Integer> adjacentNodes = graph.get(iIdx);
      for (Integer adjIdx : adjacentNodes) {
        T adjItem = vertexSpace.get(adjIdx);
        if (!discovered.contains(adjItem)) {
          q.add(adjItem);
          discovered.add(adjItem);
        }
      }
    }
  }

  public void depthFirstSearch() {
    int islands = 0;
    Set<T> discovered = new HashSet<>();
    for (T source : vertexSpace) {
      if (!discovered.contains(source)) {
        ++islands;
        dfsSubGraph(source, discovered);
        System.out.println("-----");
      }
    }
    System.out.println("No of connected components = " + islands);
  }

  private void dfsSubGraph(T source, Set<T> discovered) {
    System.out.println(source);
    discovered.add(source);
    ArrayList<Integer> adjacentVertices = graph.get(mappingTable.get(source));
    for (int ajdIdx : adjacentVertices) {
      T adjacent = vertexSpace.get(ajdIdx);
      if (!discovered.contains(adjacent)) {
        dfsSubGraph(adjacent, discovered);
      }
    }
  }

  public Integer[] shortestDistanceFrom(T source) {
    Integer[] distance = new Integer[vertexSpace.size()];
    Set<T> discovered = new HashSet<>();
    Queue<T> q = new ArrayDeque<>();

    Integer sourceIdx = mappingTable.get(source);
    distance[sourceIdx] = 0;
    discovered.add(source);
    q.add(source);

    while (!q.isEmpty()) {
      T u = q.poll();
      Integer uIdx = mappingTable.get(u);
      ArrayList<Integer> adjacentVertices = graph.get(uIdx);
      for (int vIdx : adjacentVertices) {
        T v = vertexSpace.get(vIdx);
        if (!discovered.contains(v)) {
          distance[vIdx] = 1 + distance[uIdx];
          discovered.add(v);
          q.add(v);
        }
      }
    }
    return distance;
  }

  public boolean detectLoopBfs() {
    Set<T> discovered = new HashSet<>();
    List<T> parent = new ArrayList<>();
    vertexSpace.forEach(v -> parent.add(null));

    for (T source : vertexSpace) {
      if (!discovered.contains(source)) {
        boolean loop = detectLoopBfs(source, discovered, parent);
        if (loop) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean detectLoopBfs(T source, Set<T> discovered, List<T> parent) {
    Queue<T> q = new ArrayDeque<>();
    discovered.add(source);
    q.add(source);

    while (!q.isEmpty()) {
      T u = q.poll();
      Integer uIdx = mappingTable.get(u);
      ArrayList<Integer> adjacent = graph.get(uIdx);
      for (int adjIdx : adjacent) {
        T v = vertexSpace.get(adjIdx);
        if (!discovered.contains(v)) {
          discovered.add(v);
          q.add(v);
          parent.set(adjIdx, u);
        } else if (parent.get(uIdx) != v) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean detectLoop() {
    Set<T> discovered = new HashSet<>();
    for (T source : vertexSpace) {
      if (!discovered.contains(source)) {
        boolean loop = detectLoop(discovered, source, null);
        if (loop) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean detectLoop(Set<T> discovered, T source, T parent) {
    discovered.add(source);
    ArrayList<Integer> adjacentVertices = graph.get(mappingTable.get(source));
    for (int adjIdx : adjacentVertices) {
      T adjacent = vertexSpace.get(adjIdx);
      if (!discovered.contains(adjacent)) {
        return detectLoop(discovered, adjacent, source);
      } else if (adjacent != parent) {
        return true;
      }
    }
    return false;
  }

  public boolean detectLoopDirectedDFS() {
    Set<T> discovered = new HashSet<>();
    Set<T> recursionTree = new HashSet<>();
    for (T source : vertexSpace) {
      if (!discovered.contains(source)) {
        if (detectLoopDirectedDFS(source, discovered, recursionTree)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean detectLoopDirectedDFS(T source, Set<T> discovered, Set<T> recursionTree) {
    discovered.add(source);
    recursionTree.add(source);

    ArrayList<Integer> adjacentVertices = graph.get(mappingTable.get(source));

    for (Integer adj : adjacentVertices) {
      T adjacent = vertexSpace.get(adj);
      if ((!discovered.contains(adjacent))
          && detectLoopDirectedDFS(adjacent, discovered, recursionTree)) {
        return true;
      } else if (recursionTree.contains(adjacent)) {
        return true;
      }
    }
    recursionTree.remove(source);
    return false;
  }

  public boolean detectCycleDirectedDFSCLRS() {
    int[] visited = new int[vertexSpace.size()]; //0 - All are initially unvisited
    for (int i = 0; i < vertexSpace.size(); i++) {
      //Only visit unvisited vertices
      if (visited[i] == 0 && detectCycleDirectedDFSCLRS(i, visited)) {
        return true;
      }
    }
    return false;
  }

  private boolean detectCycleDirectedDFSCLRS(int i, int[] visited) {
    visited[i] = -1; //Grey
    ArrayList<Integer> adjacentVertices = graph.get(i);

    for (Integer adjacent : adjacentVertices) {
      if (visited[adjacent] == -1) {
        return true;
      } else if (visited[adjacent] == 0 && detectCycleDirectedDFSCLRS(adjacent, visited)) {
        return true;
      }
    }

    visited[i] = 1; //Black
    return false;
  }

  public void topologicalSortingKahn() {
    int[] indegree = new int[vertexSpace.size()];
    for (List<Integer> adj : graph) {
      for (int adjIdx : adj) {
        indegree[adjIdx]++;
      }
    }

    Queue<Integer> q = new ArrayDeque<>();

    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
      }
    }

    while (!q.isEmpty()) {
      int u = q.poll();
      System.out.println("Processing " + vertexSpace.get(u));

      for (int v : graph.get(u)) {
        indegree[v]--;
        if (indegree[v] == 0) {
          q.offer(v);
        }
      }
    }

  }

  public static void main(String[] args) {
    ListGraph<String> graph = new ListGraph<>();
    graph.addVertex("Ishan");
    graph.addVertex("Isha");
    graph.addVertex("Divyan");
    graph.addVertex("Rekha");
    graph.addVertex("Sahil");
    graph.addVertex("Mr. Abc");
    graph.addEdge("Ishan", "Isha");
    graph.addEdge("Isha", "Ishan");
    graph.addEdge("Isha", "Rekha");
    graph.addEdge("Rekha", "Isha");
    graph.addEdge("Ishan", "Divyan");
    graph.addEdge("Divyan", "Ishan");
    graph.addEdge("Divyan", "Sahil");
    graph.addEdge("Sahil", "Divyan");
    //graph.addEdge("Ishan", "Rekha");
    //graph.addEdge("Rekha", "Ishan");
    System.out.println(graph.detectLoop());
  }

}
