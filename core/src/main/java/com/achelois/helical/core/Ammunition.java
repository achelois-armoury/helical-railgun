package com.achelois.helical.core;


import com.achelois.helical.annotations.CaseId;

public class Ammunition {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Ammunition.class);

    public static Bullet prepare(Status status, CaseId caseId, String comment) {
        log.info("[status: " + status + ", caseId: " + caseId + ", comment: " + comment);
        if (caseId == null) {
            return new Bullet(0, 0, "");
        }

        return new Bullet(caseId.value(), status.getValue(), comment);
    }

}
