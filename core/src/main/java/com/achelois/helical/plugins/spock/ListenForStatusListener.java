package com.achelois.helical.plugins.spock;

import com.achelois.helical.annotations.CaseId;
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
        Bullet bullet = new Bullet(caseId, Status.Failed, error.getException().getMessage());
        assert railgun.load(bullet);
    }

    public void beforeSpec(SpecInfo spec) {

    }

    public void beforeFeature(FeatureInfo feature) {
        CaseId caseId = feature.getFeatureMethod().getAnnotation(CaseId.class);
        Bullet bullet = new Bullet(caseId, Status.Passed, "");
        assert railgun.load(bullet);
    }

    public void beforeIteration(IterationInfo iteration) {
    }

    public void afterIteration(IterationInfo iteration) {
    }

    public void afterFeature(FeatureInfo feature) {
    }

    public void afterSpec(SpecInfo spec) {
    }
}
