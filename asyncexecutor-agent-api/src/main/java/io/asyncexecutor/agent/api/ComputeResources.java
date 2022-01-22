package io.asyncexecutor.agent.api;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executors;

public interface ComputeResources {
  default ListeningExecutorService executorService() {
    return MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
  }
}
