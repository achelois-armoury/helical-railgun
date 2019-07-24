package com.achelois.helical;

import com.achelois.helical.core.TestrailConfig;
import org.junit.Assert;
import org.junit.Test;

public class TestRailConfigTest {
    @Test
    public void testValidConfigValue() {
        TestrailConfig instance = TestrailConfig.getInstance();
        Assert.assertEquals("http://test2.local", instance.getEndPoint());
        Assert.assertEquals("user2", instance.getUsername());
        Assert.assertEquals("pass2", instance.getPassword());
    }
}
