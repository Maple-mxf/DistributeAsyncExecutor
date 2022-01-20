package io.asyncexecutor.context;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.function.Function;

public final class CompletionStage implements java.io.Serializable {
  private String stepId;
  private Integer order;
  @JsonIgnore private transient Function<Context, FutureResult> taskLambda;

  public CompletionStage(String stepId, Integer order, Function<Context, FutureResult> taskLambda) {
    this.stepId = stepId;
    this.order = order;
    this.taskLambda = taskLambda;
  }

  public String getStepId() {
    return stepId;
  }

  public void setStepId(String stepId) {
    this.stepId = stepId;
  }

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public Function<Context, FutureResult> getTaskLambda() {
    return taskLambda;
  }

  public void setTaskLambda(Function<Context, FutureResult> taskLambda) {
    this.taskLambda = taskLambda;
  }
}
