package com.ishan.dsalgo.greedy;

import java.util.Objects;

public class Activity implements Comparable<Activity> {

  private Integer startTime;
  private Integer endTime;

  public Activity(Integer startTime, Integer endTime) {
    this.startTime = Objects.requireNonNull(startTime);
    this.endTime = Objects.requireNonNull(endTime);
  }

  public Integer getStartTime() {
    return startTime;
  }

  public Integer getEndTime() {
    return endTime;
  }

  @Override
  public int compareTo(Activity o) {
    return this.getEndTime().compareTo(o.getEndTime());
  }

  @Override
  public String toString() {
    return "(" + startTime +
        ", " + endTime +
        ")";
  }
}
