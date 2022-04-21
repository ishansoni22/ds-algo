package com.ishan.dsalgo.graphs;

import java.util.ArrayList;
import java.util.List;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 You are given an array prerequisites where prerequisites[i] = [ai, bi]
 indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0,
and to take course 0 you should also have finished course 1. So it is impossible.

 */
public class CourseSchedule {

  /*
  The prerequisites is a directed graph.
  If the graph has a cycle, it cannot be finished
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = createGraph(numCourses, prerequisites);
    boolean[] visited = new boolean[numCourses];
    boolean[] traversalStack = new boolean[numCourses];

    for (int i = 0; i < numCourses; i++) {
      if (!visited[i] && !canFinish(i, graph, visited, traversalStack)) {
        return false;
      }
    }
    return true;
  }

  private boolean canFinish(int i, List<List<Integer>> prerequisites, boolean[] visited,
      boolean[] traversalStack) {
    visited[i] = true;
    traversalStack[i] = true;

    for (Integer pre : prerequisites.get(i)) {
      if (!visited[pre] && !canFinish(pre, prerequisites, visited, traversalStack)) {
        return false;
      } else if (traversalStack[pre]) {
        return false;
      }
    }

    traversalStack[i] = false;
    return true;
  }

  private List<List<Integer>> createGraph(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    //[0, 1] means to take 0 you first need to complete 1
    //Graph should be 1 -> 0 so that you can use topological sorting!
    for (int[] prerequisite : prerequisites) {
      graph.get(prerequisite[1]).add(prerequisite[0]);
    }

    return graph;
  }

  public static void main(String[] args) {
    CourseSchedule c = new CourseSchedule();
    System.out.println(c.canFinish(2, new int[][]{{1, 0}}));
  }

}
