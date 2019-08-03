package com.achelois.helical.core;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {

    String endPoint;
    String username;
    String password;
    int runId;
    String testplan;
    boolean enable;

    private static Settings self;

    static synchronized Settings getInstance() {
        if (self == null) {
            self = new Settings();
            return self;
        }

        return self;
    }

    private Settings() {
        Properties appProps = new Properties();

        try {

            File file = Paths.get(ClassLoader.getSystemResource("testrail.properties").toURI()).toFile();
            appProps.load(new FileInputStream(file));

            endPoint = appProps.getProperty("helical.testrail.endPoint");
            username = appProps.getProperty("helical.testrail.username");
            password = appProps.getProperty("helical.testrail.password");
            runId = Integer.parseInt(appProps.getProperty("helical.testrail.runid"));
            testplan = appProps.getProperty("helical.testrail.testplan");
            enable = Boolean.parseBoolean(appProps.getProperty("helical.enable"));

        } catch (Exception e) {

            username = "changeme";
            password = "changeme";
            endPoint = "http://changeme";
            runId = 0;
            testplan = "";
        }

    }

    @Override
    public String toString() {
        return "Settings{" +
                "endPoint='" + endPoint + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", runId='" + runId + '\'' +
                ", testplan='" + testplan + '\'' +
                '}';
    }
}
