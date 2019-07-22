package com.achelois.helical;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestrailConfig {

    public String endPoint;
    public String username;
    public String password;

    public TestrailConfig() {

    }

    public TestrailConfig init() {
        JavaPropsMapper mapper = new JavaPropsMapper();

        try {
            return mapper.readValue(
                    new File(getClass().getClassLoader().getResource("testrail.properties").getFile()),
                    TestrailConfig.class);
        } catch (Exception e) {
            return this;
        }
    }

}
