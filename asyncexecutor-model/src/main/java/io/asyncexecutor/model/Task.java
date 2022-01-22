package io.asyncexecutor.model;

import java.time.LocalDateTime;

public class Task {

  private String id;
  private String name;
  private TaskStatus status;
  private Boolean retryable;
  private Integer maxRetryTimes;
  private Integer retryTimes;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
}
