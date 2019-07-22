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

    private Railgun railgun;
    private CaseId caseId;
    private RunId runId;
    private ProjectId projectId;

    public void testRunStarted(Description description) {
        System.out.println("from run start");
        railgun = new Railgun();
    }

    public void testRunFinished(Result result) {
        System.out.println("from finished");
        railgun.shoot();
    }

    public void testFailure(Failure failure) {
        // set to fail
        System.out.println("from failure: ");
        boolean load = railgun.load(runId, caseId, Status.Failed);
        System.out.println("load: " + load);
    }

    public void testIgnored(Description description) {
        // set to ignore
    }

    public void testStarted(Description description) {

        System.out.println("#### " + description.getMethodName() + " ####");


        // set to passed
        reload(description);

        railgun.load(runId, caseId, Status.Passed);

    }

    private void reload(Description description) {
        caseId = description.getAnnotation(CaseId.class);

        runId = description.getAnnotation(RunId.class) == null ?
                description.getTestClass().getAnnotation(RunId.class) :
                description.getAnnotation(RunId.class);

        projectId = description.getAnnotation(ProjectId.class) == null ?
                description.getTestClass().getAnnotation(ProjectId.class) :
                description.getAnnotation(ProjectId.class);

    }
}
