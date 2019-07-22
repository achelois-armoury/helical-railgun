package com.achelois.helical;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.RunId;

import java.util.Objects;

public class Kekka {
    private int runId;
    private int caseId;
    private int status;

    private Kekka(int runId, int caseId, int status) {
        this.runId = runId;
        this.caseId = caseId;
        this.status = status;
    }

    public Kekka(RunId runId, CaseId caseId, Status status) {
        this(runId.value(), caseId.value(), status.getValue());
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
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
        if (!(o instanceof Kekka)) return false;
        Kekka kekka = (Kekka) o;
        return runId == kekka.runId &&
                caseId == kekka.caseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(runId, caseId);
    }

    @Override
    public String toString() {
        return "Result{" +
                "runId='" + runId + '\'' +
                ", caseId='" + caseId + '\'' +
                ", status=" + status +
                '}';
    }
}
