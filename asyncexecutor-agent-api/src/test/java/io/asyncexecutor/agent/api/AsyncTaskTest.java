package io.asyncexecutor.agent.api;

import io.asyncexecutor.context.CompletionStage;
import io.asyncexecutor.context.Context;
import io.asyncexecutor.context.CompletionFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AsyncTaskTest {

    private static class AsyncTaskImpl implements AsyncTask {

        private CompletionStage stage1 = new CompletionStage(
                // stageId
                "1",

                // orderId
                1,

                // func logic
                new Function<Context, CompletionFuture>() {
                    @Override
                    public CompletionFuture apply(Context context) {
                        // ..TODO
                        System.err.printf("context=%s \n", context);
                        return CompletionFuture.builder("").append("res", "1").build();
                    }
                });


        @Override
        public String name() {
            return "AsyncTaskImpl";
        }

        @Override
        public List<CompletionStage> stages() {
            return new ArrayList<CompletionStage>() {
                {
                    this.add(stage1);
                    this.add(stage1); // 2 or other
                    this.add(stage1);
                }
            };
        }
    }
}
