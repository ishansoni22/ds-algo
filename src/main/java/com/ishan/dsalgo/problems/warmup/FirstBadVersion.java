package com.ishan.dsalgo.problems.warmup;

/*
You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad.
Implement a function to find the first bad version.
You should minimize the number of calls to the API.

n = 5
FFFTT

o/p = 4

 */
public class FirstBadVersion extends VersionControl {

  public int firstBadVersion(int n) {

    int lowVersion = 1;
    int highVersion = n;

    while (lowVersion <= highVersion) {
      int version = lowVersion + (highVersion - lowVersion) / 2;
      if (isBadVersion(version)) {
        highVersion = version - 1;
      } else {
        lowVersion = version + 1;
      }
    }

    return lowVersion;

  }

  public static void main(String[] args) {
    FirstBadVersion fbv = new FirstBadVersion();
    System.out.println(fbv.firstBadVersion(5));
  }

}
