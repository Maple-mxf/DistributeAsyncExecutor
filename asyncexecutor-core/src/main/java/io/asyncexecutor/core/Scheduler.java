package io.asyncexecutor.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler {

  private final ExecutorService executorService;

  public Scheduler() {
    executorService = Executors.newFixedThreadPool(10);
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      executorService.submit(new Task());
    }
  }
}
