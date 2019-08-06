package com.achelois.helical.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Target(value={METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CaseId {
    int value() default 0;
}
