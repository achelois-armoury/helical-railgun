package com.achelois.helical.core;

import org.junit.Assert;
import org.junit.Test;

public class RailgunTest {
    @Test
    public void testNewRailgun() {
        Railgun railgun = new Railgun();

        Assert.assertNotNull(railgun);
        Assert.assertEquals(2, railgun.getMagazine().size());
    }
}
