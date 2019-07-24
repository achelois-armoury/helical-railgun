package com.achelois.helical.core;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.RunId;
import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Railgun {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Railgun.class);
    private Set<Kekka> results;
    private TestRail testRail;
    private TestrailConfig config;

    public Railgun() {
        config = TestrailConfig.getInstance();
        results = new HashSet<>();
        testRail = TestRail
                .builder(config.endPoint, config.username, config.password)
                .applicationName("achelois.helical-railgun")
                .build();

        log.debug("Railgun initialization complete: " + config);
    }

    public boolean load(RunId runId, CaseId caseId, Status status) {
        log.debug("Loading bullet [" + runId + ", " + caseId + ", Status: " + status + "]");

        if (runId == null | caseId == null | status == null) {
            log.warn("Defect bullet detected: loading out ... ");
            return false;
        }

        Kekka kekka = new Kekka(runId, caseId, status);
        results.remove(kekka);
        return results.add(kekka);
    }

    public void shoot() {
        log.debug("Let's turn and burn!");
        results.forEach(log::debug);

        try {

            List<ResultField> fields = testRail.resultFields().list().execute();
            results.forEach(r -> {
                testRail.results().addForCase(r.getRunId(), r.getCaseId(), new Result().setStatusId(r.getStatus()), fields).execute();
            });
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            log.warn("Great balls of fire! ... but you missed.");
        }

    }

}
