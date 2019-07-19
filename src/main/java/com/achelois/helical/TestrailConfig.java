package com.achelois.helical;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import java.io.File;
import java.io.IOException;

public class TestrailConfig {

    public String endPoint;
    public String username;
    public String password;

    public TestrailConfig get() throws IOException {
        JavaPropsMapper mapper = new JavaPropsMapper();

        return mapper.readValue(
                new File(getClass().getClassLoader().getResource("testrail.properties").getFile()),
                TestrailConfig.class);
    }

    public static void main(String[] args) throws IOException {
        TestrailConfig testrailConfig = new TestrailConfig().get();
        System.out.println(testrailConfig.endPoint);
        System.out.println(testrailConfig.password);
        System.out.println(testrailConfig.username);
    }

}
