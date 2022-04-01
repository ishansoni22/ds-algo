package com.ishan.dsalgo.bfs_dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*

https://leetcode.com/problems/01-matrix/

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.Given an m x n binary matrix mat,
return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1:

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

 */
public class Matrix {

  public int[][] updateMatrix(int[][] mat) {
    Queue<int[]> q = new ArrayDeque<>();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 0) {
          q.offer(new int[]{i, j});
        } else {
          mat[i][j] = -1;
        }
      }
    }

    distanceFrom(q, mat);
    return mat;
  }

  private void distanceFrom(Queue<int[]> q, int[][] distance) {
    int[][] neighbours = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    while (!q.isEmpty()) {
      int[] index = q.poll();
      for (int[] neighbour : neighbours) {
        int nIdxi = index[0] + neighbour[0];
        int nIdxj = index[1] + neighbour[1];
        if (nIdxi >= 0 && nIdxi < distance.length && nIdxj >= 0 && nIdxj < distance[0].length) {
          if (distance[nIdxi][nIdxj] == -1) {
            distance[nIdxi][nIdxj] = distance[index[0]][index[1]] + 1;
            q.offer(new int[]{nIdxi, nIdxj});
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Matrix m = new Matrix();
    System.out.println(
        Arrays.deepToString(m.updateMatrix(new int[][]{{0, 1, 1}, {1, 1, 0}, {1, 1, 0}})));
  }

}
