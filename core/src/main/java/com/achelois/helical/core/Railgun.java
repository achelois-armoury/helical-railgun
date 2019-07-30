package com.achelois.helical.core;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Railgun {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Railgun.class);
    private Set<Bullet> magazine;
    private TestRail testRail;
    private TestrailConfig config;

    public Railgun() {
        config = TestrailConfig.getInstance();
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

    public Set<Bullet> getMagazine() {
        return magazine;
    }

    public static class TestrailConfig {
        private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TestrailConfig.class);
        private static final String PROPERTIES_FILE_NAME = "testrail.properties";
        String endPoint;
        String username;
        String password;

        private static TestrailConfig self;

        private TestrailConfig() {

        }

        private TestrailConfig(boolean isDefault) {
            self = new TestrailConfig();
            self.endPoint = "http://changeme";
            self.username = "john";
            self.password = "changeit";

            if (!isDefault) {
                JavaPropsMapper mapper = new JavaPropsMapper();
                try {
                    URL resource = getClass().getClassLoader().getResource(PROPERTIES_FILE_NAME);
                    if (resource != null) {
                        self = mapper.readValue(new File(resource.getFile()), TestrailConfig.class);
                    } else {
                        log.warn(PROPERTIES_FILE_NAME + " not exist!");
                    }
                } catch (Exception e) {
                    log.warn("Default configs is assigned.");
                }
            }
        }

        static synchronized TestrailConfig getInstance() {

            if (self == null) {
                new TestrailConfig(false);
            }

            return self;
        }

        String getEndPoint() {
            return endPoint;
        }

        String getUsername() {
            return username;
        }

        String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "TestrailConfig{" +
                    "endPoint='" + endPoint + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
