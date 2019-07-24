package com.achelois.helical;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.RunId;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestngListenerTest {

    @org.junit.Test
    public void testTestngRuns() {
        TestNG testSuite = new TestNG();
        testSuite.setTestClasses(new Class[]{WoodenMan.class, WoodenMan2.class});
        TestngListener testngListener = new TestngListener();
        testSuite.addListener(testngListener);
        testSuite.run();

        Assert.assertEquals(testngListener.getRailgun().getMagazine().size(), 3);
    }

    @RunId(22)
    public static class WoodenMan {

        @Test
        @CaseId(33)
        public void testQiShou() {

        }

        @Test
        @RunId(11)
        @CaseId(12)
        public void testRoundHorseKick() throws Exception {
            throw new Exception("opps!");
        }
    }

    @RunId(31)
    @CaseId(32)
    public static class WoodenMan2 {
        @Test
        public void testManShao() {
        }

    }
}
