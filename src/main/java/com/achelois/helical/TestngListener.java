package com.achelois.helical;

import com.achelois.helical.core.Ammunition;
import com.achelois.helical.core.Bullet;
import com.achelois.helical.core.Railgun;
import com.achelois.helical.core.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListener implements ITestListener {
    private Railgun railgun;

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Bullet bullet = Ammunition.prepare(iTestResult.getMethod().getTestClass().getRealClass(),
                iTestResult.getMethod().getConstructorOrMethod().getMethod(),
                Status.Passed);

        railgun.load(bullet);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Bullet bullet = Ammunition.prepare(iTestResult.getMethod().getTestClass().getRealClass(),
                iTestResult.getMethod().getConstructorOrMethod().getMethod(),
                Status.Failed);

        railgun.load(bullet);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Bullet bullet = Ammunition.prepare(iTestResult.getMethod().getTestClass().getRealClass(),
                iTestResult.getMethod().getConstructorOrMethod().getMethod(),
                Status.Skip);

        railgun.load(bullet);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        railgun = new Railgun();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        railgun.shoot();
    }

    public Railgun getRailgun() {
        return railgun;
    }
}
