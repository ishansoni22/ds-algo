package com.ishan.dsalgo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class JobScheduler {

  public static void main(String[] args) {
    JobScheduler scheduler = new JobScheduler();
    List<Job> jobs = new ArrayList<>();
    jobs.add(new Job(1, 20));
    jobs.add(new Job(1, 50));
    jobs.add(new Job(2, 10));
    jobs.add(new Job(2, 100));
    jobs.add(new Job(3, 30));
    System.out.println(Arrays.toString(scheduler.schedule(jobs)));
  }

  public Job[] schedule(List<Job> jobs) {
    Collections.sort(jobs);
    Integer deadline = jobs.stream().map(Job::getDeadline)
        .max(Comparator.naturalOrder()).orElse(0);
    Job[] timeSlots = new Job[deadline];
    for (Job job : jobs) {
      fill(timeSlots, job);
    }
    return timeSlots;
  }

  private void fill(Job[] timeSlots, Job job) {
    for (int i = job.getDeadline() - 1; i >= 0; i--) {
      if (Objects.isNull(timeSlots[i])) {
        timeSlots[i] = job;
        break;
      }
    }
  }

}
