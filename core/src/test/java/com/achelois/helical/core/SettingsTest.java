package com.achelois.helical.core;

import org.junit.Assert;
import org.junit.Test;

public class SettingsTest
{
    @Test
    public void testValidConfigValue() {
        Settings instance = Settings.getInstance();
        Assert.assertEquals("https://maxleow.testrail.io", instance.endPoint);
        Assert.assertEquals("lionstrength@gmail.com", instance.username);
        Assert.assertEquals("iMgwPl8ytc58DQ5JJIOQ", instance.password);
        Assert.assertEquals(7, instance.runId);
        Assert.assertEquals("Develop - BPS", instance.testplan);

    }
}
