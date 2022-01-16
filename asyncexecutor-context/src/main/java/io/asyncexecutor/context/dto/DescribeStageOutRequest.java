package io.asyncexecutor.context.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DescribeStageOutRequest implements java.io.Serializable {
  private String taskClassName;
  private String stageId;
}
