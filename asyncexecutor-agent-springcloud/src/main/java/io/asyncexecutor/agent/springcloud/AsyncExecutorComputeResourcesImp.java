package io.asyncexecutor.agent.springcloud;

import io.asyncexecutor.agent.api.AsyncExecutorComputeResources;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
public class AsyncExecutorComputeResourcesImp implements AsyncExecutorComputeResources {

  @Override
  public ExecutorService executorService() {
    return null;
  }
}
