package io.asyncexecutor.context.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CallbackOnPerformStageRequest implements java.io.Serializable {
  private String taskId;
  private String stageId;
  private Boolean success;
  private Boolean hasError;
  private Boolean errorMsg;
}
