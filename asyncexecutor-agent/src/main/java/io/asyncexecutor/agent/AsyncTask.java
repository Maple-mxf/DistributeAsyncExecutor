package io.asyncexecutor.agent;

import io.asyncexecutor.context.CompletionStage;

import java.util.List;

public interface AsyncTask {

    String name();

    default String tag() {
        return "";
    }

    List<CompletionStage> stages();
}
