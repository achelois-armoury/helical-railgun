package com.achelois.helical;

import java.util.Objects;

public class Result {
    private String runId, projId, caseId;
    private int status;

    public Result(String runId, String projId, String caseId, int status) {
        this.runId = runId;
        this.projId = projId;
        this.caseId = caseId;
        this.status = status;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return runId.equals(result.runId) &&
                projId.equals(result.projId) &&
                caseId.equals(result.caseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runId, projId, caseId);
    }

    @Override
    public String toString() {
        return "Result{" +
                "runId='" + runId + '\'' +
                ", projId='" + projId + '\'' +
                ", caseId='" + caseId + '\'' +
                ", status=" + status +
                '}';
    }
}
