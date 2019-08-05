package com.achelois.helical.plugins.spock;

import com.achelois.helical.annotations.CaseId;
import org.spockframework.runtime.InvalidSpecException;
import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension;
import org.spockframework.runtime.extension.IGlobalExtension;
import org.spockframework.runtime.model.FeatureInfo;
import org.spockframework.runtime.model.FieldInfo;
import org.spockframework.runtime.model.MethodInfo;
import org.spockframework.runtime.model.SpecInfo;

public class SpockRunListenerExtension extends AbstractAnnotationDrivenExtension<CaseId> implements IGlobalExtension {

    @Override
    public void start() {

    }

    @Override
    public void visitSpec(SpecInfo specInfo) {
        specInfo.addListener(new ListenForStatusListener());
    }

    @Override
    public void stop() {

    }

    public void visitSpecAnnotation(CaseId annotation, SpecInfo spec) {

    }

    public void visitFeatureAnnotation(CaseId annotation, FeatureInfo feature) {

    }

    public void visitFixtureAnnotation(CaseId annotation, MethodInfo fixtureMethod) {

    }

    public void visitFieldAnnotation(CaseId annotation, FieldInfo field) {

    }



}

