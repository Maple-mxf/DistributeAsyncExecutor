package io.asyncexecutor.agent.springcloud;

import io.asyncexecutor.context.errors.agent.AgentException;

/** @see java.util.function.Function */
@FunctionalInterface
interface ThrowAgentErrorFunction<T, R> {
  R apply(T t) throws AgentException;
}
