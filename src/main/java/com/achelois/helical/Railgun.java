package com.achelois.helical;

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

    private Railgun() {

        results = new HashSet<>();
        testRail = TestRail
                .builder("http://replaceme.local/", "replaceme", "replaceme")
                .applicationName("playground")
                .build();
    }

    public boolean append(Kekka result) {
        return results.add(result);
    }

    void shoot() {

        results.forEach(System.out::println);

        List<ResultField> fields = testRail.resultFields().list().execute();
        testRail.results().addForCase(23972, 22615457, new Result().setStatusId(Skip.getValue()), fields).execute();
    }

    private static class RailgunHolder {
        static final Railgun gun = new Railgun();
    }

    static Railgun getInstance() {
        return RailgunHolder.gun;
    }
}
