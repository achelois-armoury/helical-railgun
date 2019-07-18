package com.achelois.helical;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.RunId;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Junit4Listener extends RunListener {


    public void testRunFinished(Result result) {
        System.out.println("from finished");
        Railgun.getInstance().shoot();

    }

    public void testFailure(Failure failure) {
        // set to fail
        System.out.println("from failure");
    }

    public void testIgnored(Description description) {
        // set to ignore
    }

    public void testStarted(Description description) {
        CaseId caseId = description.getAnnotation(CaseId.class);
        RunId runId = description.getAnnotation(RunId.class) == null ?
                description.getTestClass().getAnnotation(RunId.class) :
                description.getAnnotation(RunId.class);

        System.out.println("#### " + description.getMethodName() + " ####");
        System.out.println(caseId.value());
        System.out.println(runId.value());

        // set to passed
    }
}
