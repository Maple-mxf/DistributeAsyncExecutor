package io.asyncexecutor.context;

import java.util.HashMap;

/**
 * 面向开发者的API
 */
public final class CompletionFuture implements java.io.Serializable {
    private final HashMap<String, Object> stepOuts = new HashMap<>();
    private final String stageId;

    private CompletionFuture(String stageId) {
        this.stageId = stageId;
    }

    public static FutureBuilder builder(String stageId) {
        return new FutureBuilder(stageId);
    }

    public String getStageId() {
        return this.stageId;
    }

    public final Object getStepOut(String key) {
        return stepOuts.get(key);
    }

    public final static class FutureBuilder {
        private final CompletionFuture completionFuture;

        private FutureBuilder(String stageId) {
            this.completionFuture = new CompletionFuture(stageId);
        }

        public final FutureBuilder append(String key, Object value) {
            completionFuture.stepOuts.put(key, value);
            return this;
        }

        public final CompletionFuture build() {
            return this.completionFuture;
        }
    }
}
