package com.achelois.helical.junit4;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.core.Ammunition;
import com.achelois.helical.core.Bullet;
import com.achelois.helical.core.Railgun;
import com.achelois.helical.core.Status;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Junit4Listener extends RunListener {

    private Railgun railgun;
    private Bullet bullet;

    public void testRunStarted(Description description) {
        railgun = new Railgun();
    }

    public void testRunFinished(Result result) {
        railgun.shoot();
    }

    public void testFailure(Failure failure) {
        // set to fail
        bullet.setStatus(Status.Failed);
        bullet.setComment(failure.getMessage());
        railgun.load(bullet);

    }

    public void testIgnored(Description description) {
        prepare(description, Status.Skip);
    }

    public void testStarted(Description description) {
        prepare(description, Status.Passed);
    }

    private void prepare(Description description, Status status) {

        CaseId caseId = description.getAnnotation(CaseId.class);

        bullet = Ammunition.prepare(status, caseId, "");
        railgun.load(bullet);
    }

    Railgun getRailgun() {
        return railgun;
    }
}
