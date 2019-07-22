package com.achelois.helical;

import org.apache.maven.surefire.report.ReportEntry;
import org.apache.maven.surefire.report.RunListener;

public class MavenSurefireListener implements RunListener {
    @Override
    public void testSetStarting(ReportEntry reportEntry) {
        System.out.println("from mvn testSetStarting");
    }

    @Override
    public void testSetCompleted(ReportEntry reportEntry) {
        System.out.println("from mvn testSetCompleted");
    }

    @Override
    public void testStarting(ReportEntry reportEntry) {
        System.out.println("from mvn testStarting");
    }

    @Override
    public void testSucceeded(ReportEntry reportEntry) {
        System.out.println("from mvn testSucceeded");
    }

    @Override
    public void testAssumptionFailure(ReportEntry reportEntry) {
        System.out.println("from mvn testAsumptionFailure");
    }

    @Override
    public void testError(ReportEntry reportEntry) {
        System.out.println("from mvn testError");
    }

    @Override
    public void testFailed(ReportEntry reportEntry) {
        System.out.println("from mvn testFailed");
    }

    @Override
    public void testSkipped(ReportEntry reportEntry) {
        System.out.println("from mvn testSkipped");
    }

    @Override
    public void testExecutionSkippedByUser() {

        System.out.println("from mvn testExecutionSkippedByUser");
    }
}
