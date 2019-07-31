package com.achelois.helical.core;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class Configs {

    String endPoint;
    String username;
    String password;
    String runId;
    String testplan;

    private static Configs self;

    static synchronized Configs getInstance() {
        if (self == null) {
            self = new Configs();
            return self;
        }

        return self;
    }

    Configs() {
        Properties appProps = new Properties();

        try {

            File file = Paths.get(ClassLoader.getSystemResource("testrail.properties").toURI()).toFile();
            appProps.load(new FileInputStream(file));

            endPoint = appProps.getProperty("helical.testrail.endPoint");
            username = appProps.getProperty("helical.testrail.username");
            password = appProps.getProperty("helical.testrail.password");
            runId = appProps.getProperty("helical.testrail.runid");
            testplan = appProps.getProperty("helical.testrail.testplan");

        } catch (Exception e) {

            username = "changeme";
            password = "changeme";
            endPoint = "http://changeme";
            runId = "0";
            testplan = "";
        }

    }

    @Override
    public String toString() {
        return "Configs{" +
                "endPoint='" + endPoint + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", runId='" + runId + '\'' +
                ", testplan='" + testplan + '\'' +
                '}';
    }
}
