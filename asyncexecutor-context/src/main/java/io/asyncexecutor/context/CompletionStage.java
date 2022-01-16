package io.asyncexecutor.context;

import java.util.function.Function;

public final class CompletionStage implements java.io.Serializable {
    private String stepId;
    private Integer order;
    private transient Function<Context, CompletionFuture> taskLambda;

    public CompletionStage(String stepId, Integer order, Function<Context, CompletionFuture> taskLambda) {
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

    public Function<Context, CompletionFuture> getTaskLambda() {
        return taskLambda;
    }

    public void setTaskLambda(Function<Context, CompletionFuture> taskLambda) {
        this.taskLambda = taskLambda;
    }
}
