package io.asyncexecutor.core;

import io.asyncexecutor.communicator.api.CommunicatorClient;
import io.asyncexecutor.context.Context;
import io.asyncexecutor.context.dto.ApiResponse;
import io.asyncexecutor.context.dto.PerformStageRequest;
import io.asyncexecutor.context.dto.PerformStageResponse;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public final class Task implements Runnable {

  private List<Object> taskList = new ArrayList<>();

  private CommunicatorClient communicatorClient;

  @SneakyThrows // TODO
  @Override
  public void run() {
    for (Object o : taskList) {
      Context ctx = new Context();
      PerformStageRequest request =
          PerformStageRequest.builder()
              .context(ctx)
              .taskId("")
              .stageId("")
              .taskClassName("")
              .build();

      ApiResponse<PerformStageResponse> baseResponse = communicatorClient.performStage(request);

      if (baseResponse.hasError()) {
        // TODO
        return;
      }

      PerformStageResponse responseEntity = baseResponse.getResponseEntity();
      if (responseEntity == null) {
        // TODO
        return;
      }
    }
  }
}
