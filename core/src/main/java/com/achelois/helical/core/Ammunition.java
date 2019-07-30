package com.achelois.helical.core;


import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.RunId;

import java.lang.reflect.Method;

public class Ammunition {

    public static Bullet prepare(Class<?> clazz, Method method, Status status) {
        CaseId caseId = method.getAnnotation(CaseId.class) == null ?
                clazz.getAnnotation(CaseId.class) : method.getAnnotation(CaseId.class);

        RunId runId = method.getAnnotation(RunId.class) == null ?
                clazz.getAnnotation(RunId.class) : method.getAnnotation(RunId.class);

        if (caseId == null || runId == null || status == null) {
            return new Bullet(0, 0, 0);
        }

        return new Bullet(runId.value(), caseId.value(), status.getValue());
    }
}
