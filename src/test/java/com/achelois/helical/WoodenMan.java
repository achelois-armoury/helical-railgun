package com.achelois.helical;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.ProjectId;
import com.achelois.helical.annotations.RunId;
import org.junit.Test;

@RunId(1983) @ProjectId(6)
public class WoodenMan {

    @Test @CaseId(11)
    public void testWingChunStand() {

    }

    @Test @RunId(1944) @CaseId(12)
    public void testWingChunHighKick() throws Exception {
        throw new Exception("opps!");
    }
}
