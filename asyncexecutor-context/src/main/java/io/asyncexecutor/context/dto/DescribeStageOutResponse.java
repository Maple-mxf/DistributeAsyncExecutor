package io.asyncexecutor.context.dto;

import io.asyncexecutor.context.FutureResult;
import io.asyncexecutor.context.Context;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class DescribeStageOutResponse implements java.io.Serializable {

  private Context context;
  private FutureResult future;
  private String taskClassName;
  private String stageId;
  private boolean completed;
  private boolean hasError;
  private String errorMsg;
  private List<String> traces;
  private LocalDateTime completeTime;
}
