package io.asyncexecutor.context;

import java.time.LocalDateTime;
import java.util.List;

public final class Trace implements java.io.Serializable {

    private String className;
    private String method;
    private String cause;
    private List<String> traceList;
    private LocalDateTime time;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public List<String> getTraceList() {
        return traceList;
    }

    public void setTraceList(List<String> traceList) {
        this.traceList = traceList;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
