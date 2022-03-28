package com.ishan.dsalgo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {

  public List<Activity> select(List<Activity> activities) {
    List<Activity> selectedActivities = new ArrayList<>();
    Collections.sort(activities);
    int lastActivityEndTime = 1;
    for (int i = 0; i < activities.size(); i++) {
      Activity activity = activities.get(i);
      if (activity.getStartTime() >= lastActivityEndTime) {
        selectedActivities.add(activity);
        lastActivityEndTime = activity.getEndTime();
      }
    }

    return selectedActivities;
  }

  public static void main(String[] args) {
    ActivitySelection as = new ActivitySelection();
    System.out.println(
        as.select(
            Arrays.asList(
                new Activity(3, 8),
                new Activity(2, 4),
                new Activity(10, 11),
                new Activity(1, 3)
            )
        )
    );
  }

}
