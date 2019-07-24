package com.achelois.helical.core;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import java.io.File;
import java.net.URL;

public class TestrailConfig {
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

    public static synchronized TestrailConfig getInstance() {

        if (self == null) {
            new TestrailConfig(false);
        }

        return self;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
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
