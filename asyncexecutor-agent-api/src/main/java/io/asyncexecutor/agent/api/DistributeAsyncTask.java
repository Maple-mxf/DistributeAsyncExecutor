package io.asyncexecutor.agent.api;

import io.asyncexecutor.context.CompletionStage;
import io.asyncexecutor.context.RetryStrategy;

import java.util.List;

public interface DistributeAsyncTask {

  default String name() {
    return this.getClass().getSimpleName();
  }

  default boolean retryable() {
    return false;
  }

  default Integer retryMaxTimes() {
    return 3;
  }

  List<CompletionStage> stageList();

  default Long timeoutMills() {
    return -1L;
  }

  default RetryStrategy retryStrategy() {
    return RetryStrategy.RETRY_FROM_STAGE;
  }
}
