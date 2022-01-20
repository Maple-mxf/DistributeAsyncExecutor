package io.asyncexecutor.agent.api;

import io.asyncexecutor.context.dto.*;
import io.asyncexecutor.context.errors.agent.AgentException;

public interface AgentEndpoint {

  /**
   * 执行某一个stage
   *
   * @param request
   * @return
   * @throws AgentException
   */
  ApiResponse<PerformStageResponse> performStage(PerformStageRequest request) throws AgentException;

  /**
   * 成功后回调
   *
   * @param request
   * @return
   */
  ApiResponse<CallbackOnSuccessResponse> callbackOnSuccess(CallbackOnSuccessRequest request);

  ApiResponse<CallbackOnErrorResponse> callbackOnFailed(CallbackOnErrorRequest request);
}
