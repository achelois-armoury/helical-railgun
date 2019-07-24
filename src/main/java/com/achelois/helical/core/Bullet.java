package com.achelois.helical.core;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.RunId;

import java.util.Objects;

public class Bullet {
    private int runId;
    private int caseId;
    private int status;

    public Bullet(int runId, int caseId, int status) {
        this.runId = runId;
        this.caseId = caseId;
        this.status = status;
    }

    public int getCaseId() {
        return caseId;
    }

    public int getRunId() {
        return runId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bullet)) return false;
        Bullet bullet = (Bullet) o;
        return runId == bullet.runId &&
                caseId == bullet.caseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(runId, caseId);
    }

    @Override
    public String toString() {
        return "Cartridge{" +
                "runId='" + runId + '\'' +
                ", caseId='" + caseId + '\'' +
                ", status=" + status +
                '}';
    }
}
