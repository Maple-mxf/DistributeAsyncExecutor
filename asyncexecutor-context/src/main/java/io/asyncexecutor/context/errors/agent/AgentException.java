package io.asyncexecutor.context.errors.agent;

import io.asyncexecutor.context.Context;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class AgentException extends Exception {
  protected Object request;
  protected Context ctx;
  protected String errorMsg;

  public static class UnknownError extends AgentException {
    public UnknownError(Object request, Context ctx, String errorMsg) {
      super(request, ctx, errorMsg);
    }
  }

  public static class InvalidParams extends AgentException {
    public InvalidParams(Object request, Context ctx, String errorMsg) {
      super(request, ctx, errorMsg);
    }
  }

  public static class InvalidOperate extends AgentException {
    public InvalidOperate(Object request, Context ctx, String errorMsg) {
      super(request, ctx, errorMsg);
    }
  }

  public static class InternalError extends AgentException {
    public InternalError(Object request, Context ctx, String errorMsg) {
      super(request, ctx, errorMsg);
    }
  }
}
