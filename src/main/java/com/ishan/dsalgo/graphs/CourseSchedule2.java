package com.ishan.dsalgo.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 You are given an array prerequisites where prerequisites[i]
  = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return the ordering of courses you should take to finish all courses.
 If there are many valid answers, return any of them.
 If it is impossible to finish all courses, return an empty array.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
So the correct course order is [0,1].

Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take.
To take course 3 you should have finished both courses 1 and 2.
Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]

 */
public class CourseSchedule2 {

  /*
  Topological ordering using Kahn's algorithm (+ Cycle Detection)
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];

    //Create graph
    //[0, 1] means you have to take 1 before 0
    //The graph should look like 1 -> 0
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] pre : prerequisites) {
      graph.get(pre[1]).add(pre[0]);
      indegree[pre[0]]++;
    }

    int visited = 0;
    int[] order = new int[numCourses];
    Queue<Integer> q = new ArrayDeque<>();

    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
      }
    }

    while (!q.isEmpty()) {
      int u = q.poll();
      order[visited++] = u;

      for (int v : graph.get(u)) {
        indegree[v]--;
        if (indegree[v] == 0) {
          q.offer(v);
        }
      }
    }

    if (visited == numCourses) {
      return order;
    }

    return new int[]{};
  }

  public static void main(String[] args) {
    CourseSchedule2 c2 = new CourseSchedule2();
    System.out.println(Arrays.toString(c2.findOrder(2, new int[][]{})));
  }

}