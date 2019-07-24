package com.achelois.helical;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.RunId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Junit4ListenerTest {

    @Test
    public void testJunit4Run() {
        JUnitCore runner = new JUnitCore();
        Junit4Listener junit4Listener = new Junit4Listener();
        runner.addListener(junit4Listener);
        runner.run(WoodenMan.class, WoodenMan2.class);

        junit4Listener.getRailgun().getMagazine().forEach(System.out::println);

        Assert.assertEquals(junit4Listener.getRailgun().getMagazine().size(), 4);
    }

    @RunId(1983)
    public static class WoodenMan {

        @Test
        @CaseId(1)
        public void testWingChunStand() {

        }

        @Test
        @RunId(1944)
        @CaseId(1)
        public void testWingChunHighKick() throws Exception {
            throw new Exception("opps!");
        }
    }

    @RunId(1984)
    public static class WoodenMan2 {

        @Test
        @CaseId(1)
        public void testWingChunStand() {

        }

        @Test
        @RunId(1944)
        @CaseId(2)
        public void testWingChunHighKick() throws Exception {
            throw new Exception("opps!");
        }
    }
}
