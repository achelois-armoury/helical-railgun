package com.achelois.helical;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.ProjectId;
import com.achelois.helical.annotations.RunId;
import com.achelois.helical.core.Railgun;
import com.achelois.helical.core.Status;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Junit4Listener extends RunListener {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Junit4Listener.class);
    private Railgun railgun;
    private CaseId caseId;
    private RunId runId;
    private ProjectId projectId;

    public void testRunStarted(Description description) {
        log.debug("Test run started: " + description);
        railgun = new Railgun();
    }

    public void testRunFinished(Result result) {
        log.debug("test has finished was successful: " + result.wasSuccessful());
        railgun.shoot();
    }

    public void testFailure(Failure failure) {
        // set to fail
        log.debug("Test has failed: " + failure.getMessage());
        boolean load = railgun.load(runId, caseId, Status.Failed);

        log.debug("Railgun loading check: " + load);
    }

    public void testIgnored(Description description) {
        // set to ignore
    }

    public void testStarted(Description description) {

        log.debug("Test started: " + description);

        // set to passed
        prepare(description);

        railgun.load(runId, caseId, Status.Passed);

    }

    private void prepare(Description description) {
        caseId = description.getAnnotation(CaseId.class);

        runId = description.getAnnotation(RunId.class) == null ?
                description.getTestClass().getAnnotation(RunId.class) :
                description.getAnnotation(RunId.class);

        projectId = description.getAnnotation(ProjectId.class) == null ?
                description.getTestClass().getAnnotation(ProjectId.class) :
                description.getAnnotation(ProjectId.class);

    }
}
