package com.achelois.helical.core;

import org.junit.Assert;
import org.junit.Test;

public class TestProperties
{
    @Test
    public void testValidConfigValue() {
        Railgun.TestrailConfig instance = Railgun.TestrailConfig.getInstance();
        Assert.assertEquals("http://test2.local", instance.getEndPoint());
        Assert.assertEquals("user2", instance.getUsername());
        Assert.assertEquals("pass2", instance.getPassword());
    }
}
