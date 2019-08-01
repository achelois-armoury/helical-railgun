package com.achelois.helical.core;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Plan;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Railgun {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Railgun.class);
    private Set<Bullet> magazine;
    private TestRail testRail;
    private Settings config;

    public Railgun() {
        config = Settings.getInstance();
        magazine = new HashSet<>();
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

        magazine.remove(bullet);
        return magazine.add(bullet);
    }

    public void shoot() {
        if (!config.enable) {
            return;
        }

        log.debug("Let's turn and burn!");

        try {

            List<ResultField> fields = testRail.resultFields().list().execute();
            magazine.forEach(r -> testRail.results().addForCase(r.getRunId(), r.getCaseId(),
                    new Result().setStatusId(r.getStatus()), fields).execute());
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            log.warn("Great balls of fire! ... but you missed.");
        }

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

    }



    public Set<Bullet> getMagazine() {
        return magazine;
    }

}
