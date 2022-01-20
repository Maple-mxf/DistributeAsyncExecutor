package io.asyncexecutor.context;

import java.util.HashMap;

public final class FutureResult implements java.io.Serializable {
  private final HashMap<String, Object> stepOuts = new HashMap<>();
  private final String stageId;

  private FutureResult(String stageId) {
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

  public static final class FutureBuilder {
    private final FutureResult futureResult;

    private FutureBuilder(String stageId) {
      this.futureResult = new FutureResult(stageId);
    }

    public final FutureBuilder append(String key, Object value) {
      futureResult.stepOuts.put(key, value);
      return this;
    }

    public final FutureResult build() {
      return this.futureResult;
    }
  }
}
