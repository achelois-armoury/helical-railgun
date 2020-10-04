package com.achelois.helical.core;

import com.codepine.api.testrail.TestRail;
import org.junit.Assert;
import org.junit.Test;

public class RailgunTest {
    @Test
    public void testNewRailgun() {
        Railgun railgun = new Railgun();

        Assert.assertNotNull(railgun);
        Assert.assertEquals(0, railgun.getMagazine().size());
    }
}
