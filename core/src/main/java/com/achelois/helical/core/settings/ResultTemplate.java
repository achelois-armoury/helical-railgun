package com.achelois.helical.core.settings;

public class ResultTemplate {
    private String version, comment;
    private int status;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResultTemplate{" +
                "version='" + version + '\'' +
                ", comment='" + comment + '\'' +
                ", status=" + status +
                '}';
    }
}
