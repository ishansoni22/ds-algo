package com.ishan.dsalgo.linkedlist;

/*
You have a browser of one tab where you start on the homepage and you can visit another url,
get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

    BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
    void visit(string url) Visits url from the current page. It clears up all the forward history.
    string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
    string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.

 */
class BrowserHistory {

  private class BrowserNode {

    String url;
    BrowserNode next;
    BrowserNode prev;
  }

  private BrowserNode head;
  private BrowserNode current;

  public BrowserHistory(String homepage) {
    BrowserNode node = new BrowserNode();
    node.url = homepage;

    head = node;
    current = node;
  }

  public void visit(String url) {
    BrowserNode node = new BrowserNode();
    node.url = url;
    if (head == current) {
      node.next = head;
      head.prev = node;
    } else {
      current.prev.next = null;
      current.prev = node;
      node.next = current;
    }
    head = node;
    current = node;
  }

  public String back(int steps) {
    BrowserNode iterator = current;
    for (int i = 1; i <= steps && iterator.next != null; i++) {
      iterator = iterator.next;
    }
    current = iterator;
    return current.url;
  }

  public String forward(int steps) {
    BrowserNode iterator = current;
    for (int i = 1; i <= steps && iterator.prev != null; i++) {
      iterator = iterator.prev;
    }
    current = iterator;
    return current.url;
  }

  public static void main(String[] args) {
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
    browserHistory.visit("google.com");         // You are in "leetcode.com". Visit "google.com"
    browserHistory.visit("facebook.com");       // You are in "google.com". Visit "facebook.com"
    browserHistory.visit("youtube.com");        // You are in "facebook.com". Visit "youtube.com"
    System.out.println(browserHistory.back(
        1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
    System.out.println(browserHistory.back(
        1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
    System.out.println(browserHistory.forward(
        1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
    browserHistory.visit("linkedin.com");       // You are in "facebook.com". Visit "linkedin.com"
    System.out.println(browserHistory.forward(
        2));                // You are in "linkedin.com", you cannot move forward any steps.
    System.out.println(browserHistory.back(
        2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
    System.out.println(browserHistory.back(
        7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
  }

}
