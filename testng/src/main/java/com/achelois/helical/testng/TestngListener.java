package com.achelois.helical.testng;

import com.achelois.helical.annotations.CaseId;
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

        prepare(iTestResult, Status.Passed);

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        prepare(iTestResult, Status.Failed);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        prepare(iTestResult, Status.Skip);
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

    Railgun getRailgun() {
        return railgun;
    }

    private void prepare(ITestResult iTestResult, Status status) {
        CaseId caseId = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CaseId.class);
        String message = "";
        if (iTestResult.getThrowable() != null) {
            message = iTestResult.getThrowable().getMessage();
        }
        Bullet bullet = Ammunition.prepare(status, caseId, message);
        railgun.load(bullet);
    }
}
