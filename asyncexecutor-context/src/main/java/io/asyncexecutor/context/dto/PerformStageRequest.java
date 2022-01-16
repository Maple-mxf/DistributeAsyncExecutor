package io.asyncexecutor.context.dto;

import io.asyncexecutor.context.Context;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PerformStageRequest implements java.io.Serializable {
  private String taskClassName;
  private String taskId;
  private Context context;
  private String stageId;
}
