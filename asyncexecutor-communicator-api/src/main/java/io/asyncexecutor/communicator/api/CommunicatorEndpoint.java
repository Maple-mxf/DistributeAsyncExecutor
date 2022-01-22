package io.asyncexecutor.communicator.api;

import io.asyncexecutor.context.dto.*;

/** CommunicatorEndpoint 端点 */
public interface CommunicatorEndpoint {

  // 新增异步任务
  ApiResponse<SubmitAsyncTaskResponse> submitAsyncTask(SubmitAsyncTaskRequest request);

  // 上传服务心跳
  ApiResponse<PostServerInstanceHeartbeatResponse> postServerInstanceHeartbeat(
      PostServerInstanceHeartbeatRequest request);

  // 确认事件
  ApiResponse<AcknowledgeResponse> acknowledge(AcknowledgeRequest request);

  // 查询时间戳
  ApiResponse<DescribeTimestampResponse> describeTimestamp();
}
