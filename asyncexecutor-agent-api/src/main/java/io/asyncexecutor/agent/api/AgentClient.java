package io.asyncexecutor.agent.api;

import io.asyncexecutor.context.dto.*;

public interface AgentClient {

  ApiResponse<SubmitAsyncTaskResponse> submitAsyncTask(SubmitAsyncTaskRequest request);

  ApiResponse<PostServerInstanceHeartbeatResponse> postServerInstanceHeartbeat(
      PostServerInstanceHeartbeatRequest request);

  ApiResponse<AcknowledgeResponse> acknowledge(AcknowledgeRequest request);

  @Deprecated
  ApiResponse<CallbackOnPerformStageResponse> callbackOnPerform(
      CallbackOnPerformStageRequest request);

  ApiResponse<DescribeTimestampResponse> describeTimestamp();
}
