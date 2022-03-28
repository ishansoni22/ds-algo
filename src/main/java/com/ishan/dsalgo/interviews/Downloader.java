package com.ishan.dsalgo.interviews;

import java.util.concurrent.Semaphore;

public enum Downloader {

  INSTANCE;

  private Semaphore semaphore = new Semaphore(5);

  public Object download(String url) throws Exception {
    semaphore.acquire();
    System.out.println(Thread.currentThread().getName() + " downloading " + url);
    Thread.sleep(1000);
    semaphore.release();
    return url;
  }

}
