package io.asyncexecutor.context.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DescribeTimestampResponse implements java.io.Serializable {
  private LocalDateTime time;
}
