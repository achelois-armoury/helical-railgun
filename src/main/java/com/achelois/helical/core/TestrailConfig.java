package com.achelois.helical.core;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import java.io.File;

public class TestrailConfig {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TestrailConfig.class);
    private static final String PROPERTIES_FILE_NAME = "testrail.properties";
    String endPoint;
    String username;
    String password;

    private static TestrailConfig self;

    private TestrailConfig(String endPoint, String username, String password) {

        this.endPoint = endPoint;
        this.username = username;
        this.password = password;
    }

    private TestrailConfig(boolean isDefault) {
        self = new TestrailConfig("http://changeme", "john", "changeit");

        if (!isDefault) {
            JavaPropsMapper mapper = new JavaPropsMapper();
            try {
                self = mapper.readValue(
                        new File(getClass().getClassLoader().getResource(PROPERTIES_FILE_NAME).getFile()),
                        TestrailConfig.class);
            } catch (Exception e) {
                log.warn(PROPERTIES_FILE_NAME + " not exist!");
                log.debug("Default configs is assigned.");
            }
        }
    }

    public static synchronized TestrailConfig getInstance() {

        if (self == null) {
            new TestrailConfig(false);
        }

        return self;
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
