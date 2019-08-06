package com.achelois.helical.plugins.spock;

import com.achelois.helical.annotations.CaseId;
import com.achelois.helical.core.Ammunition;
import com.achelois.helical.core.Bullet;
import com.achelois.helical.core.Railgun;
import com.achelois.helical.core.Status;
import org.spockframework.runtime.AbstractRunListener;
import org.spockframework.runtime.model.ErrorInfo;
import org.spockframework.runtime.model.FeatureInfo;
import org.spockframework.runtime.model.IterationInfo;
import org.spockframework.runtime.model.SpecInfo;

public class ListenForStatusListener extends AbstractRunListener {

    private Railgun railgun;

    ListenForStatusListener(Railgun railgun) {
        this.railgun = railgun;
    }

    @Override
    public void error(ErrorInfo error) {
        CaseId caseId = error.getMethod().getAnnotation(CaseId.class);
        Bullet bullet = Ammunition.prepare(Status.Failed, caseId, "");
        railgun.load(bullet);
    }

    public void beforeSpec(SpecInfo spec) {

    }

    public void beforeFeature(FeatureInfo feature) {
        CaseId caseId = feature.getFeatureMethod().getAnnotation(CaseId.class);
        Bullet bullet = Ammunition.prepare(Status.Passed, caseId, "");
        railgun.load(bullet);
    }

    public void beforeIteration(IterationInfo iteration) {
        System.out.println("before iteration: " + iteration.getName());
    }

    public void afterIteration(IterationInfo iteration) {
        System.out.println("after iteration: " + iteration.getName());
    }

    public void afterFeature(FeatureInfo feature) {
        System.out.println("after feature: " + feature.getName());
    }

    public void afterSpec(SpecInfo spec) {
        System.out.println("after spec: " + spec.getName());
    }
}
