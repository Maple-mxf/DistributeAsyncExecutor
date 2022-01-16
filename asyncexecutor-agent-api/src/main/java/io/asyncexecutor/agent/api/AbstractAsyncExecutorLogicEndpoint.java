package io.asyncexecutor.agent.api;

import io.asyncexecutor.context.CompletionStage;
import io.asyncexecutor.context.dto.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public abstract class AbstractAsyncExecutorLogicEndpoint implements AsyncExecutorLogicEndpoint {

  private AsyncExecutorComputeResources computeResources;

  @Override
  public final PerformStageResponse performStageLogic(PerformStageRequest request) {
    ExecutorService service = computeResources.executorService();

    AsyncExecutorFutureMemory futureMemory = new AsyncExecutorFutureMemory();

    List<CompletionStage> completionStages =
        futureMemory.addStage(request.getTaskId(), request.getStageId());

    // TODO  考虑线程池的阻塞问题
    for (CompletionStage stage : completionStages) {
      Future<Object> future =
          service.submit(
              () -> {
                try {
                  return stage.getTaskLambda().apply(request.getContext());
                } catch (Exception cause) {
                  // TODO  request.getContext()
                  return null;
                }
              });
      // Add Callbacks
    }
    return PerformStageResponse.builder().build();
  }

  @Override
  public final DescribeStageOutResponse describeStageOutLogic(DescribeStageOutRequest request) {
    return DescribeStageOutResponse.builder().build();
  }

  @Override
  public final CallbackOnSuccessResponse callbackOnSuccessLogic(CallbackOnSuccessRequest request) {
    return CallbackOnSuccessResponse.builder().build();
  }

  @Override
  public final CallbackOnErrorResponse callbackOnFailedLogic(CallbackOnErrorRequest request) {
    return CallbackOnErrorResponse.builder().build();
  }
}
