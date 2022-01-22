package io.asyncexecutor.context.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CallbackOnPerformStageResponse implements java.io.Serializable {
  private String taskId;
  private String stageId;
}
