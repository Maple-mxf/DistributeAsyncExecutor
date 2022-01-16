package io.asyncexecutor.agent.api;

import io.asyncexecutor.context.CompletionFuture;
import io.asyncexecutor.context.CompletionStage;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public final class AsyncExecutorFutureMemory {

  private final ConcurrentHashMap<String, ConcurrentHashMap<String, CompletionFuture>> table =
      new ConcurrentHashMap<>();

  private final ConcurrentHashMap<String, AsyncTask> asyncTaskConcurrentHashMap =
      new ConcurrentHashMap<>();

  public List<CompletionStage> addStage(String taskId, String stageId) {
    AsyncTask asyncTask = asyncTaskConcurrentHashMap.get(taskId);
    List<CompletionStage> stages = asyncTask.stages();
    List<CompletionStage> completionStages =
        stages.stream().filter(s -> s.getStepId().equals(stageId)).collect(Collectors.toList());

    return completionStages;
  }
}
