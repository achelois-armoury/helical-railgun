package com.achelois.helical.core;

import com.achelois.helical.core.settings.Setting;
import org.junit.Assert;
import org.junit.Test;

public class SettingsTest
{
    @Test
    public void testValidConfigValue() {
        Setting instance = Settings.getInstance();
        Assert.assertEquals("https://maxleow.testrail.io", instance.getEndpoint());
        Assert.assertEquals("lionstrength@gmail.com", instance.getUsername());
        Assert.assertEquals(7, instance.getRunid());
        Assert.assertTrue(instance.isEnable());

    }
}
