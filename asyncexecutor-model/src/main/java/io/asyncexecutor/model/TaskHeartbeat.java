package io.asyncexecutor.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskHeartbeat {
  private String taskId;
  private List<String> completedStageIds;
  private String stageId; // 当前执行的stageId
  private LocalDateTime startTime;
  private LocalDateTime lastActiveTime;
  private LocalDateTime endTime;
  private String instanceHost;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
