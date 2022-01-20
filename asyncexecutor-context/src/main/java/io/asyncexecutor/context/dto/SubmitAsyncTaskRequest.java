package io.asyncexecutor.context.dto;

import io.asyncexecutor.context.CompletionStage;
import io.asyncexecutor.context.RetryStrategy;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/** @see io.asyncexecutor.context.Context */
@Data
@Builder
public class SubmitAsyncTaskRequest implements java.io.Serializable {
  private String taskClassName;
  private String taskId;
  private String taskName;
  private Boolean retryable;
  private Integer retryMaxTimes;
  private LocalDateTime submitTime;
  private LocalDateTime timeoutMoment;
  private Map<String, Object> inputArgs;
  private RetryStrategy retryStrategy;
  private List<CompletionStage> stageList;
}
