package io.asyncexecutor.agent.api;

import io.asyncexecutor.context.dto.*;

/** 逻辑处理断点 */
interface AsyncExecutorLogicEndpoint {

  @Endpoint
  ApiResponse<PerformStageResponse> performStage(PerformStageRequest request);

  PerformStageResponse performStageLogic(PerformStageRequest request);

  @Endpoint
  ApiResponse<DescribeStageOutResponse> describeStageOut(DescribeStageOutRequest request);

  DescribeStageOutResponse describeStageOutLogic(DescribeStageOutRequest request);

  @Endpoint
  ApiResponse<CallbackOnSuccessResponse> callbackOnSuccess(CallbackOnSuccessRequest request);

  CallbackOnSuccessResponse callbackOnSuccessLogic(CallbackOnSuccessRequest request);

  @Endpoint
  ApiResponse<CallbackOnErrorResponse> callbackOnFailed(CallbackOnErrorRequest request);

  CallbackOnErrorResponse callbackOnFailedLogic(CallbackOnErrorRequest request);
}
