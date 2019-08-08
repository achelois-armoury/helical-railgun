package com.achelois.helical.core;

import com.achelois.helical.core.settings.Setting;
import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;
import com.codepine.api.testrail.model.Test;

import java.util.ArrayList;
import java.util.List;

public class Railgun {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Railgun.class);
    private List<Result> magazine;
    private TestRail testRail;
    private Setting config;

    public Railgun() {
        config = Settings.getInstance();
        magazine = new ArrayList<>();
        testRail = TestRail
                .builder(config.getEndpoint(), config.getUsername(), config.getPassword())
                .applicationName("achelois.helical-railgun")
                .build();

        log.debug("Railgun initialization complete: " + config);
        init();
    }

    public boolean load(Bullet bullet) {
        log.debug("Loading bullet [" + bullet + "]");

        if (bullet == null || bullet.getCaseId() == 0) {
            log.warn("Defect bullet detected: loading out ... ");
            return false;
        }

        magazine.stream().parallel()
                .filter(item -> item.getCaseId().equals(bullet.getCaseId()))
                .forEach(item -> item
                        .setStatusId(bullet.getStatus())
                        .setComment(bullet.getComment())
                );

        return true;
    }

    private void init() {
        if (!config.isEnable()) {
            return;
        }

        try {

            List<Test> tests = testRail.tests().list(config.getRunid()).execute();

            log.info("total test retrieved: " + tests.size());
            tests.stream().parallel().forEach(t -> magazine.add(
                    new Result()
                            .setCaseId(t.getCaseId())
                            .setStatusId(config.getResult_template().getStatus())
                            .setComment(config.getResult_template().getComment())
                            .setVersion(config.getResult_template().getVersion())
            ));

        } catch (Exception e) {
            log.warn("initialization failed: no test retrieved!", e.getCause());
        }
    }

    public List<Result> shoot() {
        if (!config.isEnable()) {
            return null;
        }

        log.debug("Let's turn and burn!");

        List<ResultField> fields = testRail.resultFields().list().execute();
        return testRail.results().addForCases(config.getRunid(), magazine, fields).execute();

    }

    public List<Result> getMagazine() {
        return magazine;
    }
}
