package com.achelois.helical.junit4;

import com.achelois.helical.core.Ammunition;
import com.achelois.helical.core.Bullet;
import com.achelois.helical.core.Railgun;
import com.achelois.helical.core.Status;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.lang.reflect.Method;

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
        railgun.load(bullet);
    }

    public void testIgnored(Description description) throws Exception {
        prepare(description, Status.Skip);
    }

    public void testStarted(Description description) throws Exception {
        prepare(description, Status.Passed);
    }

    private void prepare(Description description, Status status) throws NoSuchMethodException {

        Method method = description.getTestClass().getDeclaredMethod(description.getMethodName());
        bullet = Ammunition.prepare(description.getTestClass(), method, status);
        railgun.load(bullet);
    }

    Railgun getRailgun() {
        return railgun;
    }
}
