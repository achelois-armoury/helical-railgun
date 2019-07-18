package com.achelois.helical;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.RunId;
import org.junit.Test;

@RunId("1983")
public class WoodenMan2 {

    @Test
    @CaseId("611")
    public void testWingChunStand() {
        System.out.println("prepare man shou");
    }

    @Test
    @RunId("1944")
    @CaseId("1111")
    public void testWingChunHighKick() throws Exception {
        System.out.println("aim the lower chin");
        throw new Exception("opps!");
    }
}
