package com.achelois.helical.core;

public enum Status {
    Passed(1),
    Blocked(2),
    Retest(4),
    Failed(5),
    Clarification(6),
    Skip(7);

    private final int value;

    Status(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
