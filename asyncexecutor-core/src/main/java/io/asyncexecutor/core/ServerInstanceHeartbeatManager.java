package io.asyncexecutor.core;

import io.asyncexecutor.context.dto.PostServerInstanceHeartbeatRequest;

import java.time.LocalDateTime;
import java.util.List;

public class ServerInstanceHeartbeatManager {

  public void recv(
      List<PostServerInstanceHeartbeatRequest.TaskDescriptor> taskDescriptors,
      LocalDateTime timestamp) {

    for (PostServerInstanceHeartbeatRequest.TaskDescriptor descriptor : taskDescriptors) {

      // 1 更新心跳

      // 2
    }
  }

  public void run(){

  }
}
