package com.achelois.helical.core;


import com.achelois.helical.annotations.CaseId;

public class Ammunition {

    public static Bullet prepare(Status status, CaseId caseId) {
        if (caseId == null) {
            return new Bullet(0, 0, 0);
        }

        return new Bullet(Integer.parseInt(Settings.getInstance().runId), caseId.value(), status.getValue());
    }

}
