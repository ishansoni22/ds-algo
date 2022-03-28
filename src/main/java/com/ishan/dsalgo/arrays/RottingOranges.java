package com.ishan.dsalgo.arrays;

import java.util.ArrayDeque;
import java.util.Queue;

/*
You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class RottingOranges {

  private int[][] adjCells = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

  class Orange {

    private int i;
    private int j;

    private Orange(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  /*
  BFS
   */
  public int orangesRotting(int[][] grid) {
    int freshOranges = 0;
    Queue<Orange> rottenOranges = new ArrayDeque<>();

    //Find fresh and rotten oranges in the first pass
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          freshOranges += 1;
        } else if (grid[i][j] == 2) {
          rottenOranges.add(new Orange(i, j));
        }
      }
    }

    int time = 0;
    while (freshOranges > 0 && !rottenOranges.isEmpty()) {
      int rottenPerTime = rottenOranges.size();
      boolean newRotten = false;
      for (int i = 1; i <= rottenPerTime; i++) {
        Orange orange = rottenOranges.poll();
        for (int[] adj : adjCells) {
          int x = orange.i + adj[0];
          int y = orange.j + adj[1];
          if (willRot(grid, x, y)) {
            --freshOranges;
            grid[x][y] = 2;
            rottenOranges.offer(new Orange(x, y));
            newRotten = true;
          }
        }
      }
      if (!newRotten) {
        break;
      }
      ++time;
    }
    return freshOranges > 0 ? -1 : time;
  }

  private boolean willRot(int[][] grid, int i, int j) {
    if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length) {
      if (grid[i][j] == 1) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    RottingOranges ro = new RottingOranges();
    System.out.println(ro.orangesRotting(new int[][]{{0, 2}}));
  }

}
