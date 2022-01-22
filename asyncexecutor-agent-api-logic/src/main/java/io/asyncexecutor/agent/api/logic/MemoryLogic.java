package io.asyncexecutor.agent.api.logic;

import io.asyncexecutor.agent.api.DistributeAsyncTask;
import io.asyncexecutor.context.FutureResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MemoryLogics是一个线程安全的类
 *
 * <p>缓存当前服务实例的执行任务列表以及每个任务Stage
 */
public final class MemoryLogic {

  private MemoryLogic() {}

  public static final MemoryLogic INSTANCE = new MemoryLogic();

  private final Map<String, ConcurrentHashMap<String, FutureResult>> table =
      new ConcurrentHashMap<>();

  private final ConcurrentHashMap<String, DistributeAsyncTask> taskClassNameMapping =
      new ConcurrentHashMap<>();

  public DistributeAsyncTask getAsyncTaskFromClassName(String className) {
    return taskClassNameMapping.get(className);
  }

  public FutureResult getStageResult(String taskId, String stageId) {
    ConcurrentHashMap<String, FutureResult> stageResultMap =
        table.computeIfAbsent(taskId, s -> new ConcurrentHashMap<>());
    return stageResultMap.get(stageId);
  }

  public Map<DistributeAsyncTask, LinkedHashMap<String, FutureResult>> getTaskList() {
    return Collections.emptyMap();
  }
}
