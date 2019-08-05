package com.achelois.helical.annotations;

import com.achelois.helical.plugins.spock.SpockRunListenerExtension;
import org.spockframework.runtime.extension.ExtensionAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Target(value={METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtensionAnnotation(SpockRunListenerExtension.class)
public @interface CaseId {
    int value() default 0;
}
