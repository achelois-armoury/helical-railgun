package com.achelois.helical;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import java.io.File;
import java.io.IOException;

public class TestrailConfig {

    public String endPoint;
    public String username;
    public String password;

    public static TestrailConfig get() throws IOException {


        return new TestrailConfig();
    }

    public void test() throws IOException {
        JavaPropsMapper mapper = new JavaPropsMapper();
        TestrailConfig config = mapper.readValue(new File("testrail.properties"), TestrailConfig.class);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(TestrailConfig.get().endPoint);
    }

}
