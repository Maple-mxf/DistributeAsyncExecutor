package io.asyncexecutor.model;

import java.time.LocalDateTime;

@Deprecated
public class AsyncExecutorHeartbeat {
  private String instanceId;
  private String instanceIp;
  private LocalDateTime time;
}
