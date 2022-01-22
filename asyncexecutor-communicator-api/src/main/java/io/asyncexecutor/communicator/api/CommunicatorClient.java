package io.asyncexecutor.communicator.api;

import io.asyncexecutor.context.dto.ApiResponse;
import io.asyncexecutor.context.dto.PerformStageRequest;
import io.asyncexecutor.context.dto.PerformStageResponse;
import io.asyncexecutor.context.errors.agent.AgentException;

/** 调度Agent的中间层 */
public interface CommunicatorClient {

  ApiResponse<PerformStageResponse> performStage(PerformStageRequest request) throws AgentException;
}
