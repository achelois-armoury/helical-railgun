package com.achelois.helical.core;

import com.achelois.helical.core.settings.Setting;
import org.junit.Assert;
import org.junit.Test;

public class SettingsTest
{
    @Test
    public void testValidConfigValue() {
        Setting instance = Settings.getInstance();
        Assert.assertEquals("https://maxleow2.testrail.io", instance.getEndpoint());
        Assert.assertEquals("maxengiu@outlook.com", instance.getUsername());
        Assert.assertEquals(1, instance.getRunid());
        Assert.assertTrue(instance.isEnable());

    }
}
