package com.achelois.testrail;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class CustomJunitListenerTest {

    @Test
    public void testCustomRun() {
        JUnitCore runner = new JUnitCore();

        runner.addListener(new Junit4Listener());
        runner.run(WoodenMan.class);
    }
}
