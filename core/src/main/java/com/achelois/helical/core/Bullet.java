package com.achelois.helical.core;

import com.achelois.helical.annotations.CaseId;

public class Bullet {
    private String comment;
    private CaseId caseId;
    private Status status;

    public Bullet(CaseId caseId, Status status, String comment) {
        this.comment = comment;
        this.caseId = caseId;
        this.status = status;
    }

    int getCaseId() {
        return caseId == null ? 0 : caseId.value();
    }

    String getComment() {
        return comment;
    }

    int getStatus() {
        return status == null ? 0 : status.getValue();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "comment='" + comment + '\'' +
                ", caseId=" + caseId +
                ", status=" + status +
                '}';
    }
}
