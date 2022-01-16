package io.asyncexecutor.context;

import java.util.function.Function;

public final class CompletionStage implements java.io.Serializable {
    private String stepId;
    private String order;
    private transient Function<Context, Future> taskLambda;

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Function<Context, Future> getTaskLambda() {
        return taskLambda;
    }

    public void setTaskLambda(Function<Context, Future> taskLambda) {
        this.taskLambda = taskLambda;
    }
}
