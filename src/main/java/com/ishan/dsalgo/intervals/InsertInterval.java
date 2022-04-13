package com.ishan.dsalgo.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.

You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
 and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 */
public class InsertInterval {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> timeline = new ArrayList<>();

    for (int[] interval : intervals) {
      // The new interval ends before this one starts,
      // Add the new interval and choose this interval as the new interval to be inserted
      if (newInterval[1] < interval[0]) {
        timeline.add(newInterval);
        newInterval = interval;
        //This interval ends before the new interval starts, simply add this interval to the solution
      } else if (interval[1] < newInterval[0]) {
        timeline.add(interval);
      } else {
        //Overlap! - Merge intervals
        newInterval[0] = Math.min(interval[0], newInterval[0]);
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      }
    }

    //Insert the new interval (This will already be adjusted in case of overlaps)
    timeline.add(newInterval);

    return timeline.toArray(new int[0][2]);
  }

  /*
  Inefficient

  Iterate over all intervals
  Find the overlapping intervals
  From the overlapping intervals, find minStart and maxEnd
  Remove all overlapping intervals
  Add the new minStart, maxEnd interval
  Sort based on start time
   */
  public int[][] insertNaive(int[][] intervals, int[] newInterval) {
    List<int[]> timeline = new ArrayList<>();
    for (int[] interval : intervals) {
      timeline.add(interval);
    }

    List<int[]> overLapping = new ArrayList<>();
    int minStart = newInterval[0];
    int maxEnd = newInterval[1];
    //Find all overlapping intervals with the newInterval
    for (int i = 0; i < timeline.size(); i++) {
      int[] interval = timeline.get(i);
      if (isOverLapping(interval, newInterval)) {
        overLapping.add(interval);
        minStart = Math.min(minStart, interval[0]);
        maxEnd = Math.max(maxEnd, interval[1]);
      }
    }

    for (int i = 0; i < overLapping.size(); i++) {
      timeline.remove(overLapping.get(i));
    }

    timeline.add(new int[]{minStart, maxEnd});
    timeline.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));

    int[][] newTimeline = new int[timeline.size()][2];
    int c = 0;
    for (int[] interval : timeline) {
      newTimeline[c++] = interval;
    }
    return newTimeline;
  }

  /*
    The next interval starts before the previous one ends!
   */
  private boolean isOverLapping(int[] interval, int[] newInterval) {
    /* It's overlapping if the interval starts before newInterval and newInterval start time is less than intervals end time */
    if (interval[0] < newInterval[0]) {
      return newInterval[0] <= interval[1];
      /* It's overlapping if new interval starts before interval and interval's start time is less than new intervals end time*/
    } else {
      return interval[0] <= newInterval[1];
    }
  }

  public static void main(String[] args) {
    InsertInterval i = new InsertInterval();
    System.out.println(
        Arrays.deepToString(i.insertNaive(new int[][]{},
            new int[]{4, 8})));
  }

}
