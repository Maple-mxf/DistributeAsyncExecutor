package io.asyncexecutor.context.dto;

import io.asyncexecutor.context.FutureResult;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PostServerInstanceHeartbeatRequest implements java.io.Serializable {
  private List<TaskDescriptor> taskDescriptors;
  private LocalDateTime time;

  @Data
  @Builder
  public static class TaskDescriptor implements java.io.Serializable {
    private String taskId;
    private List<StageDescriptor> stageDescriptors;
  }

  @Data
  @Builder
  public static class StageDescriptor implements java.io.Serializable {
    private String stageId;
    private FutureResult futureResult;
  }
}
