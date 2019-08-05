package com.achelois.helical.core;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;
import com.codepine.api.testrail.model.Run;

import java.util.ArrayList;
import java.util.List;

public class Railgun {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Railgun.class);
    private List<Result> magazine;
    private TestRail testRail;
    private Settings config;

    public Railgun() {
        config = Settings.getInstance();
        magazine = new ArrayList<>();
        testRail = TestRail
                .builder(config.endPoint, config.username, config.password)
                .applicationName("achelois.helical-railgun")
                .build();

        log.debug("Railgun initialization complete: " + config);
        init();
    }

    public boolean load(Bullet bullet) {
        log.debug("Loading bullet [" + bullet + "]");

        if (bullet == null) {
            log.warn("Defect bullet detected: loading out ... ");
            return false;
        }


        Result result = magazine.stream().parallel()
                .filter(item -> item.getCaseId().equals(bullet.getCaseId()))
                .findAny()
                .orElse(null);

        if (result == null) {

            return magazine.add(new Result()
                    .setCaseId(bullet.getCaseId())
                    .setStatusId(bullet.getStatus())
                    .setComment(bullet.getComment()));

        } else {
            magazine.stream().parallel()
                    .filter(item -> item.getCaseId().equals(bullet.getCaseId()))
                    .forEach(item -> item
                            .setStatusId(bullet.getStatus())
                            .setComment(bullet.getComment()));

            return false;
        }

    }

    public void init() {
        try {
            Run run = testRail.runs().get(config.runId).execute();
            run.getCaseIds().stream().parallel().forEach(c -> {
                magazine.add(new Result()
                        .setCaseId(c)
                        .setStatusId(Status.Skip.getValue())
                        .setComment("Test has not executed!"));
            });

        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }

    public List<Result> shoot() {
        if (!config.enable) {
            return null;
        }

        log.debug("Let's turn and burn!");

        List<ResultField> fields = testRail.resultFields().list().execute();
        return testRail.results().addForCases(config.runId, magazine, fields).execute();

    }

    public List<Result> getMagazine() {
        return magazine;
    }

}
