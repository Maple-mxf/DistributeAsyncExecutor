package io.asyncexecutor.agent.api.logic;

import io.asyncexecutor.agent.api.AgentClient;
import io.asyncexecutor.agent.api.DistributeAsyncTask;
import io.asyncexecutor.context.CompletionStage;
import io.asyncexecutor.context.dto.ApiResponse;
import io.asyncexecutor.context.dto.DescribeTimestampResponse;
import io.asyncexecutor.context.dto.SubmitAsyncTaskRequest;
import io.asyncexecutor.context.dto.SubmitAsyncTaskResponse;
import io.asyncexecutor.context.errors.agent.AgentException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class DistributeAsyncExecutor {

  // Init
  private DistributeAsyncExecutor() {
    ServerHeartPoster.INSTANCE.start();
  }

  public static final DistributeAsyncExecutor INSTANCE = new DistributeAsyncExecutor();

  private AgentClient agentClientImp;

  public <T extends DistributeAsyncTask> void submitAsyncTask(@NonNull T task)
      throws AgentException {

    // 1 参数检测
    final List<CompletionStage> stageList;
    if ((stageList = task.stageList()) == null || stageList.isEmpty())
      throw new AgentException.InvalidParams(null, null, "");

    // 2 获取分布式环境下的时间戳
    final ApiResponse<DescribeTimestampResponse> describeTimeBaseResponse;
    if ((describeTimeBaseResponse = agentClientImp.describeTimestamp()) == null)
      throw new AgentException.UnknownError(null, null, "");

    if (describeTimeBaseResponse.hasError())
      throw new AgentException.InvalidOperate(null, null, "");

    final DescribeTimestampResponse describeTimestampResponse;
    if ((describeTimestampResponse = describeTimeBaseResponse.getResponse()) == null)
      throw new AgentException.InternalError(null, null, "");

    LocalDateTime now = describeTimestampResponse.getTime();
    LocalDateTime timeoutMoment = now.plusNanos(task.timeoutMills());

    // 3 构建请求
    SubmitAsyncTaskRequest request =
        SubmitAsyncTaskRequest.builder()
            .taskId(UUID.randomUUID().toString())
            .taskClassName(task.getClass().getName())
            .inputArgs(new HashMap<>())
            .retryMaxTimes(task.retryMaxTimes())
            .retryStrategy(task.retryStrategy())
            .timeoutMoment(timeoutMoment)
            .submitTime(now)
            .stageList(stageList)
            .build();

    // 4 提交任务执行请求
    ApiResponse<SubmitAsyncTaskResponse> baseResponse = agentClientImp.submitAsyncTask(request);
  }
}
