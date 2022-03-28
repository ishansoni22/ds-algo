package com.ishan.dsalgo.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixGraph<T> {

  private int[][] graph = null;
  private T[] vertexSpace = null;
  private Map<T, Integer> mappingTable = new HashMap<>();

  public MatrixGraph(T[] vertices) {
    graph = new int[vertices.length][vertices.length];
    vertexSpace = vertices;
    for (int i = 0; i < vertices.length; i++) {
      mappingTable.put(vertices[i], i);
    }
  }

  public boolean hasEdge(T t1, T t2) {
    Integer ver1 = mappingTable.get(t1);
    Integer ver2 = mappingTable.get(t2);
    return graph[ver1][ver2] == 1;
  }

  public void addEdge(T t1, T t2) {
    Integer ver1 = mappingTable.get(t1);
    Integer ver2 = mappingTable.get(t2);
    graph[ver1][ver2] = 1;
  }

  public void removeEdge(T t1, T t2) {
    Integer ver1 = mappingTable.get(t1);
    Integer ver2 = mappingTable.get(t2);
    graph[ver1][ver2] = 0;
  }

  public List<T> getRelations(T t1) {
    List<T> relations = new ArrayList<>();
    Integer vertex = mappingTable.get(t1);
    int[] vertexRelations = graph[vertex];
    for (int i = 0; i < vertexRelations.length; i++) {
      if (vertexRelations[i] == 1) {
        relations.add(vertexSpace[i]);
      }
    }
    return relations;
  }

  public static void main(String[] args) {
    MatrixGraph<String> matrixGraph = new MatrixGraph<>(
        new String[]{"Ishan", "Divyan", "Isha", "Mr. ABC", "Mrs. ABC"});
    matrixGraph.addEdge("Ishan", "Divyan");
    matrixGraph.addEdge("Divyan", "Ishan");
    matrixGraph.addEdge("Ishan", "Isha");
    matrixGraph.addEdge("Isha", "Ishan");
    matrixGraph.addEdge("Mr. ABC", "Mrs. ABC");
    matrixGraph.addEdge("Mrs. ABC", "Mr. ABC");
    System.out.println(matrixGraph.getRelations("Ishan"));
  }

}
