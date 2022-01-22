package io.asyncexecutor.agent.api.logic;

import io.asyncexecutor.agent.api.AgentClient;
import io.asyncexecutor.agent.api.DistributeAsyncTask;
import io.asyncexecutor.context.FutureResult;
import io.asyncexecutor.context.dto.ApiResponse;
import io.asyncexecutor.context.dto.PostServerInstanceHeartbeatRequest;
import io.asyncexecutor.context.dto.PostServerInstanceHeartbeatResponse;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

final class ServerHeartPoster {

  private ServerHeartPoster() {}

  static final ServerHeartPoster INSTANCE = new ServerHeartPoster();

  AgentClient agentClient;

  void start() {
    new Timer().scheduleAtFixedRate(new PosterServerHeartTask(), 3L, 3L);
  }

  private class PosterServerHeartTask extends TimerTask {
    @Override
    public void run() {
      Map<DistributeAsyncTask, LinkedHashMap<String, FutureResult>> instanceTaskList =
          MemoryLogic.INSTANCE.getTaskList();
      if (instanceTaskList.size() == 0) {}

      List<PostServerInstanceHeartbeatRequest.TaskInfo> taskInfoList =
          instanceTaskList.values().stream()
              .map(
                  e -> {
                    List<PostServerInstanceHeartbeatRequest.StageInfo> stageInfoList =
                        e.entrySet().stream()
                            .map(
                                t ->
                                    PostServerInstanceHeartbeatRequest.StageInfo.builder()
                                        .stageId(t.getKey())
                                        .futureResult(t.getValue())
                                        .build())
                            .collect(Collectors.toList());

                    return PostServerInstanceHeartbeatRequest.TaskInfo.builder()
                        .taskId("")
                        .stageInfoList(stageInfoList)
                        .build();
                  })
              .collect(Collectors.toList());

      PostServerInstanceHeartbeatRequest request =
          PostServerInstanceHeartbeatRequest.builder()
              .taskInfoList(taskInfoList)
              .time(LocalDateTime.now())
              .build();

      ApiResponse<PostServerInstanceHeartbeatResponse> baseResponse =
          ServerHeartPoster.this.agentClient.postServerInstanceHeartbeat(request);

      // 如果出现错误需要重试
      if (baseResponse == null || baseResponse.hasError()) {}

      // ParseResponse
      PostServerInstanceHeartbeatResponse response = baseResponse.getResponse();
    }
  }
}
