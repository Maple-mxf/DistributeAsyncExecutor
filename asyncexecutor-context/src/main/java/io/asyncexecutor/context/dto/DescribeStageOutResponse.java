package io.asyncexecutor.context.dto;

import io.asyncexecutor.context.CompletionFuture;
import io.asyncexecutor.context.Context;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class DescribeStageOutResponse implements java.io.Serializable {

  private Context context;
  private CompletionFuture future;
  private String taskClassName;
  private String stageId;
  private boolean completed;
  private boolean hasError;
  private String errorMsg;
  private List<String> traces;
  private LocalDateTime completeTime;
}
