package com.achelois.helical.core;


import com.achelois.helical.annotations.CaseId;

public class Ammunition {

    public static Bullet prepare(Status status, CaseId caseId, String comment) {
        if (caseId == null) {
            return new Bullet(0, 0, "");
        }

        return new Bullet(caseId.value(), status.getValue(), comment);
    }

}
