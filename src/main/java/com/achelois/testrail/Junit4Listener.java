package com.achelois.testrail;

import com.achelois.testrail.annotations.CaseId;
import com.achelois.testrail.annotations.RunId;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Junit4Listener extends RunListener {


    public void testRunFinished(Result result) throws Exception {
        System.out.println("from finished");

    }

    public void testFailure(Failure failure) throws Exception {
        // set to fail
        System.out.println("from failure");
    }

    public void testIgnored(Description description) throws Exception {
        // set to ignore
    }

    public void testStarted(Description description) throws Exception {
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
