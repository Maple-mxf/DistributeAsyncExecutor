package io.asyncexecutor.core;

public class Application {

  private final Scheduler scheduler = new Scheduler();
  private final ServerInstanceHeartbeatManager sihm = new ServerInstanceHeartbeatManager();

  public static void main(String[] args) {
    Application application = new Application();

    application.scheduler.run();
    application.sihm.run();

  }
}
