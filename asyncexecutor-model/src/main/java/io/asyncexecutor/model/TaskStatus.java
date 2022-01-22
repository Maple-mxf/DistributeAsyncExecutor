package io.asyncexecutor.model;

public enum TaskStatus {

  /** 已初始化 */
  Inited,

  /** 运行中 */
  Running,

  /** 任务已分配 */
  Assigned,

  /** 任务已完成 */
  Completed,

  /** 任务执行失败 */
  Failed,

  /** 任务回调成功 */
  Callbacked,

  /** 任务回调失败 */
  CallbackFailed,
}
