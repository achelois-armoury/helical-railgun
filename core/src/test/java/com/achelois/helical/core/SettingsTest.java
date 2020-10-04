package com.achelois.helical.core;

import com.achelois.helical.core.settings.Setting;
import org.junit.Assert;
import org.junit.Test;

public class SettingsTest
{
    @Test
    public void testValidConfigValue() {
        Setting instance = Settings.getInstance();
        Assert.assertEquals("https://run.mocky.io/v3/3cc1c239-cb22-4eaa-8ea9-730eae3ac2d7", instance.getEndpoint());
        Assert.assertEquals("maxengiu@outlook.com", instance.getUsername());
        Assert.assertEquals(1, instance.getRunid());
        Assert.assertTrue(instance.isEnable());

    }
}
