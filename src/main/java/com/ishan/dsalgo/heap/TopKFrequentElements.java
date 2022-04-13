package com.ishan.dsalgo.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

 */
public class TopKFrequentElements {

  private class Frequency implements Comparable<Frequency> {

    int value;
    int frequency;

    private Frequency(int v, int f) {
      this.value = v;
      this.frequency = f;
    }

    @Override
    public int compareTo(Frequency o) {
      return Integer.compare(this.frequency, o.frequency);
    }
  }

  public int[] topKFrequentSimple(int[] nums, int k) {
    Arrays.sort(nums); //O(nlogn)
    PriorityQueue<Frequency> q = new PriorityQueue<>(k + 1);

    int lastDistinctIdx = 0;
    int lastItemFrequency = 1;
    for (int i = 1; i < nums.length; i++) { //O(nlogn -> Iterate + Add to a HEAP)
      if (nums[i] != nums[lastDistinctIdx]) {
        //Insert the last item with the given frequency
        q.offer(new Frequency(nums[lastDistinctIdx], lastItemFrequency));
        if (q.size() > k) {
          q.poll();
        }
        lastDistinctIdx = i;
        lastItemFrequency = 1;
      } else {
        ++lastItemFrequency;
      }
    }
    //Insert last item
    q.offer(new Frequency(nums[lastDistinctIdx], lastItemFrequency));
    if (q.size() > k) {
      q.poll();
    }

    int[] result = new int[k];
    int i = k - 1;
    while (!q.isEmpty()) {
      result[i] = q.poll().value;
      --i;
    }

    return result;
  }

  public static void main(String[] args) {
    TopKFrequentElements t = new TopKFrequentElements();
    System.out.println(
        Arrays.toString(t.topKFrequentSimple(new int[]{1}, 1)));
  }

}
