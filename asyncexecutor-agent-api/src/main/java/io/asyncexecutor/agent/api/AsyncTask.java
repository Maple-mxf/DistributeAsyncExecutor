package io.asyncexecutor.agent.api;

import io.asyncexecutor.context.CompletionStage;
import io.asyncexecutor.context.RetryStrategy;

import java.util.List;

public interface AsyncTask {

  default String name() {
    return this.getClass().getSimpleName();
  }

  default String tag() {
    return "";
  }

  List<CompletionStage> stages();

  default Long timeoutMills() {
    return -1L;
  }

  default RetryStrategy retryStrategy() {
    return RetryStrategy.RETRY_FROM_STAGE;
  }
}
