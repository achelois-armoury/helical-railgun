package com.achelois.testrail.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Target(value={METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CaseId {
    public int value() default 0;
}
