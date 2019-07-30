package com.achelois.helical.core;

import org.junit.Assert;
import org.junit.Test;

public class ConfigsTest
{
    @Test
    public void testValidConfigValue() {
        Configs instance = new Configs();
        Assert.assertEquals("http://test2.local", instance.endPoint);
        Assert.assertEquals("user2", instance.username);
        Assert.assertEquals("pass2", instance.password);
    }
}
