package io.asyncexecutor.agent.api.logic;

import io.asyncexecutor.agent.api.AgentClient;

public class AgentClientLogic {
  final AgentClient agentClient;

  public AgentClientLogic(AgentClient agentClient) {
    this.agentClient = agentClient;
  }

  public void callbackOnPerform() {}
}
