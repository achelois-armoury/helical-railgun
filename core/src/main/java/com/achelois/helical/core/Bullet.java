package com.achelois.helical.core;

public class Bullet {
    private String comment;
    private int caseId;
    private int status;

    Bullet(int caseId, int status, String comment) {
        this.comment = comment;
        this.caseId = caseId;
        this.status = status;
    }

    int getCaseId() {
        return caseId;
    }

    String getComment() {
        return comment;
    }

    int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.getValue();
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
