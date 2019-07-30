package com.achelois.helical.core;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class Configs {

    private static final String PROPERTIES_FILE_NAME = "testrail.properties";
    private final Properties appProps;
    String endPoint;
    String username;
    String password;

    Configs() {
        appProps = new Properties();

        try {

            File file = Paths.get(ClassLoader.getSystemResource(PROPERTIES_FILE_NAME).toURI()).toFile();
            appProps.load(new FileInputStream(file));
            endPoint = appProps.getProperty("endPoint");
            username = appProps.getProperty("username");
            password = appProps.getProperty("password");
        } catch (Exception e) {

            username = "changeme";
            password = "changeme";
            endPoint = "http://changeme";
        }

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
