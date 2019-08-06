package com.achelois.helical.plugins.spock;

import com.achelois.helical.core.Railgun;
import org.spockframework.runtime.extension.IGlobalExtension;
import org.spockframework.runtime.model.SpecInfo;

public class SpockGlobalListenerExt implements IGlobalExtension {
    private Railgun railgun;

    @Override
    public void start() {
        railgun = new Railgun();
    }

    @Override
    public void visitSpec(SpecInfo spec) {
        spec.addListener(new ListenForStatusListener(railgun));
    }

    @Override
    public void stop() {
        railgun.shoot();
    }
}
