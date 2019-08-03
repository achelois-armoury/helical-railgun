package com.achelois.helical.core;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Milestone;
import com.codepine.api.testrail.model.Plan;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;

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

    public List<Result> shoot() {
        if (!config.enable) {
            return null;
        }

        log.debug("Let's turn and burn!");

        List<ResultField> fields = testRail.resultFields().list().execute();
        return testRail.results().addForCases(config.runId, magazine, fields).execute();

    }

    public static void main(String[] args) {
        TestRail build = TestRail
                .builder("https://maxleow.testrail.io", "lionstrength@gmail.com", "iMgwPl8ytc58DQ5JJIOQ")
                .applicationName("achelois.helical-railgun")
                .build();

        Plan.Entry entry = new Plan.Entry();
        entry.setName("Component Test by Max");


        Plan p = build.plans().get(2).execute();
        p.getEntries().forEach(System.out::println);

        Milestone milestone = build.milestones().get(3).execute();
        System.out.println(milestone);
        System.out.println(milestone.getProjectId());

    }

    public List<Result> getMagazine() {
        return magazine;
    }

}
