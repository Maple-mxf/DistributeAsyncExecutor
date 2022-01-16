package io.asyncexecutor.agent.api;

import io.asyncexecutor.context.dto.DescribeAsyncTaskRequest;
import io.asyncexecutor.context.dto.DescribeAsyncTaskResponse;
import io.asyncexecutor.context.dto.SubmitAsyncTaskRequest;
import io.asyncexecutor.context.dto.SubmitAsyncTaskResponse;

public interface AsyncExecutorRpcClient {

  SubmitAsyncTaskResponse submitAsyncTask(SubmitAsyncTaskRequest request);

  DescribeAsyncTaskResponse DescribeAsyncTask(DescribeAsyncTaskRequest request);
}
