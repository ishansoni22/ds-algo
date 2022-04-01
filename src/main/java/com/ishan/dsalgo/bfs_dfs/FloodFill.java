package com.ishan.dsalgo.bfs_dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*

https://leetcode.com/problems/flood-fill/

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor.
You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel,
plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
Replace the color of all of the aforementioned pixels with newColor

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]

 */
public class FloodFill {

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int oldColor = image[sr][sc];
    if (oldColor == newColor) return image;

    int[][] fourDirectionAdj = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Queue<int[]> queue = new ArrayDeque<>();
    image[sr][sc] = newColor;
    queue.add(new int[]{sr, sc});

    while (!queue.isEmpty()) {
      int[] pixel = queue.poll();
      for (int[] adj : fourDirectionAdj) {
        int neighbourR = pixel[0] + adj[0];
        int neighbourC = pixel[1] + adj[1];

        if (neighbourR >= 0 && neighbourR < image.length
            && neighbourC >= 0 && neighbourC < image[0].length) {
          if (image[neighbourR][neighbourC] == oldColor) {
            image[neighbourR][neighbourC] = newColor;
            queue.offer(new int[]{neighbourR, neighbourC});
          }
        }
      }
    }
    return image;
  }

  public static void main(String[] args) {
    FloodFill floodFill = new FloodFill();
    System.out.println(Arrays
        .deepToString(floodFill.floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2)));
  }

}
