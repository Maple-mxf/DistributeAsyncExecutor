package io.asyncexecutor.agent.api.logic;

import io.asyncexecutor.agent.api.ComputeResources;
import io.asyncexecutor.agent.api.DistributeAsyncTask;
import io.asyncexecutor.context.CompletionStage;
import io.asyncexecutor.context.FutureResult;
import io.asyncexecutor.context.dto.*;
import io.asyncexecutor.context.errors.agent.AgentException;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import static java.util.stream.Collectors.toList;

public class AgentEndpointLogic {

  private final ComputeResources computeResources;
  private final MemoryLogic memory;

  public AgentEndpointLogic(ComputeResources computeResources, MemoryLogic memory) {
    this.computeResources = computeResources;
    this.memory = memory;
  }

  public PerformStageResponse performStageLogic(PerformStageRequest request) throws AgentException {
    final DistributeAsyncTask task;
    if ((task = memory.getAsyncTaskFromClassName(request.getTaskClassName())) == null)
      throw new AgentException.InvalidParams(request, request.getContext(), "");

    final List<CompletionStage> stages;
    if ((stages = task.stageList().stream().filter(Objects::nonNull).collect(toList())) == null
        || stages.isEmpty())
      throw new AgentException.InvalidOperate(request, request.getContext(), "");

    final ExecutorService service;
    if ((service = computeResources.executorService()) == null)
      throw new AgentException.InvalidOperate(request, request.getContext(), "");

    List<Callable<FutureResult>> callableList =
        stages.stream()
            .map(s -> (Callable<FutureResult>) () -> s.getTaskLambda().apply(request.getContext()))
            .collect(toList());

    for (Callable<FutureResult> callable : callableList) {
      try {
        Future<FutureResult> resultFuture = service.submit(callable);
      } catch (RejectedExecutionException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  public CallbackOnSuccessResponse callbackOnSuccessLogic(CallbackOnSuccessRequest request)
      throws AgentException {
    return null;
  }

  public CallbackOnErrorResponse callbackOnFailedLogic(CallbackOnErrorRequest request)
          throws AgentException {
    return null;
  }
}
