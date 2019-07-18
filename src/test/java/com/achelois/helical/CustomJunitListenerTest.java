package com.achelois.helical;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class CustomJunitListenerTest {

    @Test
    public void testJunit4Run() {
        JUnitCore runner = new JUnitCore();

        runner.addListener(new Junit4Listener());
        runner.run(WoodenMan.class, WoodenMan2.class);
    }
}
