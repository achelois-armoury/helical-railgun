package com.achelois.helical.core;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import java.io.File;

public class TestrailConfig {

    public String endPoint;
    public String username;
    public String password;

    private static TestrailConfig self;

    private TestrailConfig() {
        JavaPropsMapper mapper = new JavaPropsMapper();

        try {
            self = mapper.readValue(
                    new File(getClass().getClassLoader().getResource("testrail.properties").getFile()),
                    TestrailConfig.class);
        } catch (Exception e) {
            self = null;
        }
    }

    public static synchronized TestrailConfig getInstance() {

        if (self == null) {
            new TestrailConfig();
        }

        return self;
    }

}
