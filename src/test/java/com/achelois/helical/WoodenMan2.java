package com.achelois.helical;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.ProjectId;
import com.achelois.helical.annotations.RunId;
import org.junit.Test;

@RunId(1983) @ProjectId(6)
public class WoodenMan2 {

    @Test
    @CaseId(11)
    public void testWingChunStand() {
        System.out.println("prepare man shou");
    }

    @Test
    @RunId(1944)
    @CaseId(12)
    public void testWingChunHighKick() throws Exception {
        System.out.println("aim the lower chin");
        throw new Exception("opps!");
    }
}
