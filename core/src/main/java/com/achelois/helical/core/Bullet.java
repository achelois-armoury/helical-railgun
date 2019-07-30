package com.achelois.helical.core;

import java.util.Objects;

public class Bullet {
    private int runId;
    private int caseId;
    private int status;

    Bullet(int runId, int caseId, int status) {
        this.runId = runId;
        this.caseId = caseId;
        this.status = status;
    }

    int getCaseId() {
        return caseId;
    }

    int getRunId() {
        return runId;
    }

    int getStatus() {
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
