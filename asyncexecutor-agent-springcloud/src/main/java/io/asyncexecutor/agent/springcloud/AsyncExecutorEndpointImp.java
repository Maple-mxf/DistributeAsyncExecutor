package io.asyncexecutor.agent.springcloud;

import io.asyncexecutor.agent.api.AbstractAsyncExecutorLogicEndpoint;
import io.asyncexecutor.agent.api.AsyncExecutorFutureMemory;
import io.asyncexecutor.agent.api.AsyncTask;
import io.asyncexecutor.context.CompletionFuture;
import io.asyncexecutor.context.CompletionStage;
import io.asyncexecutor.context.dto.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "")
public class AsyncExecutorEndpointImp extends AbstractAsyncExecutorLogicEndpoint {

  final AsyncExecutorComputeResourcesImp computeResourcesImp;
  final AsyncExecutorFutureMemory futureMemory;
  final AsyncTask asyncTask;

  @Autowired
  public AsyncExecutorEndpointImp(
      AsyncExecutorComputeResourcesImp computeResourcesImp,
      AsyncExecutorFutureMemory futureMemory,
      AsyncTask asyncTask) {
    this.computeResourcesImp = computeResourcesImp;
    this.futureMemory = futureMemory;
    this.asyncTask = asyncTask;
  }

  @Override
  public ApiResponse<PerformStageResponse> performStage(PerformStageRequest request) {
    List<CompletionStage> stages =
        asyncTask.stages().stream()
            .filter(t -> t.getStepId().equals(request.getStageId()))
            .collect(Collectors.toList());

    if (stages.isEmpty()) {
      return ApiResponse.ok();
    }
    //
    ExecutorService executorService = computeResourcesImp.executorService();

    //
    stages.forEach(
        stage -> {
          try {
            executorService.submit(
                () -> {
                  try {
                    CompletionFuture completionFuture =
                        stage.getTaskLambda().apply(request.getContext());
                  } catch (Error error) {
                    error.printStackTrace();
                  }
                  return null;
                });
          } catch (Exception cause) {
            cause.printStackTrace();
          }
        });

    return ApiResponse.ok();
  }

  @Override
  public ApiResponse<DescribeStageOutResponse> describeStageOut(DescribeStageOutRequest request) {
    return null;
  }

  @Override
  public ApiResponse<CallbackOnSuccessResponse> callbackOnSuccess(
      CallbackOnSuccessRequest request) {
    return null;
  }

  @Override
  public ApiResponse<CallbackOnErrorResponse> callbackOnFailed(CallbackOnErrorRequest request) {
    return null;
  }
}
