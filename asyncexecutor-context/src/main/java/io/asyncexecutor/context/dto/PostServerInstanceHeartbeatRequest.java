package io.asyncexecutor.context.dto;

import io.asyncexecutor.context.FutureResult;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PostServerInstanceHeartbeatRequest implements java.io.Serializable {
  private List<TaskInfo> taskInfoList;
  private LocalDateTime time;

  @Data
  @Builder
  public static class TaskInfo implements java.io.Serializable {
    private String taskId;
    private List<StageInfo> stageInfoList;
  }

  @Data
  @Builder
  public static class StageInfo implements java.io.Serializable {
    private String stageId;
    private FutureResult futureResult;
  }
}
