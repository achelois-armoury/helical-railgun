package com.achelois.helical.testng;

import com.achelois.helical.annotations.CaseId;
import org.testng.Assert;
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

        org.junit.Assert.assertEquals(0, testngListener.getRailgun().getMagazine().size());
    }

    @Test
    public static class WoodenMan {

        @Test
        @CaseId(6)
        public void testQiShou() {
            System.out.println("testing qi shou");
        }

        @Test
        @CaseId(7)
        public void testRoundHorseKick() {
            assert true : "testRoundHorseKick has problem";
            Assert.assertTrue(false);
        }
    }

    @Test
    public static class WoodenMan2 {
        @Test
        @CaseId(8)
        public void testManShao() {
            System.out.println("testing manshou");
        }

    }
}
