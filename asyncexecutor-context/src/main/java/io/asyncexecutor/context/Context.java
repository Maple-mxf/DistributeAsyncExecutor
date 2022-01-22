package io.asyncexecutor.context;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
public final class Context implements java.io.Serializable {
  /** 任务类ClassName */
  private String taskClassName;
  /** 任务ID */
  private String taskId;
  /** 任务Tag */
  private String tag;
  /** 任务名称 */
  private String taskName;
  /** 失败是否可以重试 */
  private Boolean retryable;
  /** 任务提交时间 */
  private LocalDateTime submitTime;
  /** 超时时间 */
  private LocalDateTime timeoutMoment;
  /** 任务启动参数 */
  private ConcurrentHashMap<String, Object> inputArgs;
  /** 执行过程中的trace信息 */
  private CopyOnWriteArrayList<Trace> traces;
  /** 阶段ID */
  private volatile String stageId;
  /** 分布式任务执行TraceId 利用链路追踪 */
  private String traceId;

  protected void save() {}
}
