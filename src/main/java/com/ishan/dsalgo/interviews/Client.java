package com.ishan.dsalgo.interviews;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(20);

    for (int i = 1; i <= 20; i++) {
      int finalI = i;
      pool.submit(() -> Downloader.INSTANCE.download("url://" + finalI));
    }

    pool.shutdown();
  }

}
