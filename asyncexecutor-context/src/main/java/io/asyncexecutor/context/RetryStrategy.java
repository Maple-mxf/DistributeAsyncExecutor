package io.asyncexecutor.context;

public enum RetryStrategy implements java.io.Serializable {
  /** 从Task层面重试 */
  RETRY_FROM_TASK,

  /** 从Stage层面重试 */
  RETRY_FROM_STAGE,

  /** 放弃重试 */
  GIVE_UP;
}
