package io.asyncexecutor.context;

import java.util.HashMap;

public final class Future implements java.io.Serializable {
    private final HashMap<String, Object> stepOuts = new HashMap<>();

    private Future() {
    }

    public static FutureBuilder builder() {
        return new FutureBuilder();
    }

    public final Object getStepOut(String key) {
        return stepOuts.get(key);
    }

    public final static class FutureBuilder {
        private final Future future;

        private FutureBuilder() {
            this.future = new Future();
        }

        public final FutureBuilder append(String key, Object value) {
            future.stepOuts.put(key, value);
            return this;
        }

        public final Future build() {
            return this.future;
        }
    }
}
