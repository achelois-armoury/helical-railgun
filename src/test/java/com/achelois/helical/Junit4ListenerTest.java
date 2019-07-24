package com.achelois.helical;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.ProjectId;
import com.achelois.helical.annotations.RunId;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class Junit4ListenerTest {

    @Test
    public void testJunit4Run() {
        JUnitCore runner = new JUnitCore();

        runner.addListener(new Junit4Listener());
        runner.run(WoodenMan.class, WoodenMan2.class);
    }

    @RunId(1983) @ProjectId(6)
    public static class WoodenMan {

        @Test @CaseId(11)
        public void testWingChunStand() {

        }

        @Test @RunId(1944) @CaseId(12)
        public void testWingChunHighKick() throws Exception {
            throw new Exception("opps!");
        }
    }

    @RunId(1983) @ProjectId(6)
    public static class WoodenMan2 {

        @Test
        @CaseId(11)
        public void testWingChunStand() {

        }

        @Test
        @RunId(1944)
        @CaseId(12)
        public void testWingChunHighKick() throws Exception {
            throw new Exception("opps!");
        }
    }
}
