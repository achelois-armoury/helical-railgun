package com.achelois.helical.core;

import org.junit.Assert;
import org.junit.Test;

public class ConfigsTest
{
    @Test
    public void testValidConfigValue() {
        Configs instance = Configs.getInstance();
        Assert.assertEquals("http://test2.local", instance.endPoint);
        Assert.assertEquals("user1", instance.username);
        Assert.assertEquals("pass1", instance.password);
        Assert.assertEquals("22", instance.runId);
        Assert.assertEquals("Develop - BPS", instance.testplan);

    }
}
