package com.ishan.dsalgo.greedy;

import java.util.Objects;

public class Job implements Comparable<Job> {

  private Integer deadline;
  private Integer profit;

  public Job(Integer deadline, Integer profit) {
    this.deadline = Objects.requireNonNull(deadline);
    this.profit = Objects.requireNonNull(profit);
  }

  public Integer getDeadline() {
    return deadline;
  }

  public Integer getProfit() {
    return profit;
  }

  @Override
  public int compareTo(Job other) {
    return other.getProfit().compareTo(this.getProfit());
  }

  @Override
  public String toString() {
    return "Job{" +
        "deadline=" + deadline +
        ", profit=" + profit +
        '}';
  }

}
