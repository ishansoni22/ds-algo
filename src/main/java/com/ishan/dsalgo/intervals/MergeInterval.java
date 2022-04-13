package com.ishan.dsalgo.intervals;

import java.util.Arrays;
import java.util.LinkedList;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 */
public class MergeInterval {

  /*

If we sort the intervals by their start value,
then each set of intervals that can be merged will appear as a contiguous "run" in the sorted list.

First, we sort the list as described.
Then, we insert the first interval into our merged list and continue considering each interval in turn as follows:
 If the current interval begins after the previous interval ends,
 then they do not overlap and we can append the current interval to merged.
 Otherwise, they do overlap, and we merge them by updating the end of the previous interval if it is less than the end of the current interval.
   */
  public int[][] merge(int[][] intervals) {
    LinkedList<int[]> timeline = new LinkedList<>();

    //Sort the input intervals based on their start time
    Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

    for (int[] interval : intervals) {
      /* If the interval list is empty, or the start time of this interval is greater then the
      end time of the last interval, their is no overlapping!
       */
      if (timeline.isEmpty() || interval[0] > timeline.getLast()[1]) {
        timeline.add(interval);
      } else {
        //Overlap!
        //Merge the last and this interval
        int start = Math.min(interval[0], timeline.getLast()[0]);
        int end = Math.max(interval[1], timeline.getLast()[1]);
        timeline.getLast()[0] = start;
        timeline.getLast()[1] = end;
      }
    }
    return timeline.toArray(new int[timeline.size()][2]);
  }

}
