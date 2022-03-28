package com.ishan.dsalgo.problems.warmup;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user,
 and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

    Twitter() Initializes your twitter object.
    void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId.
    Each call to this function will be made with a unique tweetId.

    List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed.
    Each item in the news feed must be posted by users who the user followed or by the user themself.
    Tweets must be ordered from most recent to least recent.

    void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.

    void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.

Example 1:

Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

 */
public class Twitter {

  private class Tweet {

    private int tweetId;
    private int userId;

    Tweet(int tweetId, int userId) {
      this.tweetId = tweetId;
      this.userId = userId;
    }

    public int getTweetId() {
      return tweetId;
    }

    public int getUserId() {
      return userId;
    }
  }

  private List<Tweet> tweets = new ArrayList<>();
  private Map<Integer, Set<Integer>> followMap = new HashMap<>();
  private Map<Integer, Set<Integer>> followersMap = new HashMap<>();
  private Map<Integer, Deque<Integer>> timelineCache = new HashMap<>();

  public Twitter() {

  }

  public void postTweet(int userId, int tweetId) {
    tweets.add(new Tweet(tweetId, userId));
    addToTimelineCache(userId, tweetId);
    followersMap.getOrDefault(userId, Collections.emptySet())
        .forEach(followerId -> addToTimelineCache(followerId, tweetId));
  }

  public List<Integer> getNewsFeed(int userId) {
    if (timelineCache.containsKey(userId)) {
      return new ArrayList<>(timelineCache.get(userId));
    }

    List<Integer> timeline = new ArrayList<>();

    Set<Integer> follows = followMap.getOrDefault(userId, Collections.emptySet());
    int count = 0;

    for (int i = tweets.size() - 1; i >= 0; i--) {
      Tweet t = tweets.get(i);
      if (follows.contains(t.getUserId()) || userId == t.getUserId()) {
        timeline.add(t.getTweetId());
        ++count;
      }
      if (count == 10) {
        break;
      }
    }

    timelineCache.put(userId, new ArrayDeque<>(timeline));
    return timeline;
  }

  public void follow(int followerId, int followeeId) {
    addFollow(followerId, followeeId);
    addFollower(followerId, followeeId);
    clearTimeCacheFor(followerId);
  }

  public void unfollow(int followerId, int followeeId) {
    removeFollow(followerId, followeeId);
    removeFollower(followerId, followeeId);
    clearTimeCacheFor(followerId);
  }

  private void addToTimelineCache(int userId, int tweetId) {
    //Add this tweet to this user's timeline feed
    if (timelineCache.containsKey(userId)) {
      Deque<Integer> timeline = timelineCache.get(userId);
      if (timeline.size() >= 10) {
        timeline.removeLast();
        timeline.addFirst(tweetId);
      } else {
        timeline.addFirst(tweetId);
      }
    }
  }

  private void addFollow(int followerId, int followeeId) {
    if (followMap.containsKey(followerId)) {
      followMap.get(followerId).add(followeeId);
    } else {
      Set<Integer> uf = new HashSet<>();
      uf.add(followeeId);
      followMap.put(followerId, uf);
    }
  }

  private void addFollower(int followerId, int followeeId) {
    if (followersMap.containsKey(followeeId)) {
      followersMap.get(followeeId).add(followerId);
    } else {
      Set<Integer> uf = new HashSet<>();
      uf.add(followerId);
      followersMap.put(followeeId, uf);
    }
  }

  private void clearTimeCacheFor(int userId) {
    timelineCache.remove(userId);
  }

  private void removeFollow(int followerId, int followeeId) {
    if (followMap.containsKey(followerId)) {
      followMap.get(followerId).remove(followeeId);
    }
  }

  private void removeFollower(int followerId, int followeeId) {
    if (followersMap.containsKey(followeeId)) {
      followersMap.get(followeeId).remove(followerId);
    }
  }

}
