package com.achelois.helical;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.annotations.ProjectId;
import com.achelois.helical.annotations.RunId;
import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.achelois.helical.Status.Skip;

public class Railgun {
    private Set<Kekka> results;
    private TestRail testRail;
    private TestrailConfig config;

    public Railgun() {
        config = TestrailConfig.getInstance();
        results = new HashSet<>();
        testRail = TestRail
                .builder(config.endPoint, config.username, config.password)
                .applicationName("achelois.helical-railgun")
                .build();
    }

    public boolean load(RunId runId, CaseId caseId, Status status) {
        System.out.printf("%s, %s, %d\n", runId.value(), caseId.value(), status.getValue());

        Kekka kekka = new Kekka(runId, caseId, status);
        results.remove(kekka);
        return results.add(kekka);
    }

    void shoot() {

        results.forEach(System.out::println);

        try {

            List<ResultField> fields = testRail.resultFields().list().execute();
            results.forEach(r -> {
                testRail.results().addForCase(r.getRunId(), r.getCaseId(), new Result().setStatusId(r.getStatus()), fields).execute();
            });
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

}
