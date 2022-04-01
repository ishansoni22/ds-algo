package com.ishan.dsalgo.bfs_dfs;

/*

https://leetcode.com/problems/max-area-of-island/

You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

 */
public class MaxAreaOfIsland {

  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;
    //Isn't the grid already a graph?
    int[][] visited = new int[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        int current = 0;
        if (grid[i][j] != 0 && visited[i][j] != 1) {
          current = visit(i, j, grid, visited);
          max = Math.max(max, current);
        }
      }
    }
    return max;
  }

  private int visit(int i, int j, int[][] grid, int[][] visited) {
    if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || grid[i][j] == 0
        || visited[i][j] == 1) {
      return 0;
    }
    visited[i][j] = 1;
    return 1
        + visit(i - 1, j, grid, visited)
        + visit(i + 1, j, grid, visited)
        + visit(i, j - 1, grid, visited)
        + visit(i, j + 1, grid, visited);
  }

  public static void main(String[] args) {
    MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
    System.out.println(maxAreaOfIsland.maxAreaOfIsland(
        new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
  }

}
