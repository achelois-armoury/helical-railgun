package com.achelois.helical.testng;
import com.achelois.helical.annotations.CaseId;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestngListenerTest {

    @org.junit.Test
    public void testTestngRuns() {
        TestNG testSuite = new TestNG();
        testSuite.setTestClasses(new Class[]{WoodenMan.class, WoodenMan2.class});
        TestngListener testngListener = new TestngListener();
        testSuite.addListener(testngListener);
        testSuite.run();

        org.junit.Assert.assertEquals(3, testngListener.getRailgun().getMagazine().size());
    }

    public static class WoodenMan {

        @Test
        @CaseId(33)
        public void testQiShou() {

        }

        @Test
        @CaseId(12)
        public void testRoundHorseKick() throws Exception {
            throw new Exception("opps!");
        }
    }


    public static class WoodenMan2 {
        @Test @CaseId(32)
        public void testManShao() {
        }

    }
}
