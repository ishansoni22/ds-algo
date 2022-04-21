package com.ishan.dsalgo.heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosetPointsToOrigin {

  private class Point implements Comparable<Point> {

    private double distance;
    private int[] coordinates;

    private Point(double distance, int[] coordinates) {
      this.distance = distance;
      this.coordinates = coordinates;
    }

    @Override
    public int compareTo(Point o) {
      return Double.compare(this.distance, o.distance);
    }
  }

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Point> maxHeap =
        new PriorityQueue<>(k + 1, Comparator.reverseOrder());

    for (int[] point : points) {
      double distance = Math.sqrt((double) point[0] * point[0] + (double) point[1] * point[1]);
      maxHeap.offer(new Point(distance, point));
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    int count = 0;
    int[][] closest = new int[k][2];
    Iterator<Point> iterator = maxHeap.iterator();
    while (iterator.hasNext()) {
      closest[count++] = iterator.next().coordinates;
    }
    return closest;
  }

}
