package com.achelois.helical;

import java.util.HashSet;
import java.util.Set;

public class Railgun {
    private Set<Result> results;

    private Railgun() {
        results = new HashSet<>();
    }

    public boolean append(Result result) {
        return results.add(result);
    }

    void shoot() {

        results.forEach(System.out::println);
    }

    private static class RailgunHolder {
        static final Railgun gun = new Railgun();
    }

    static Railgun getInstance() {
        return RailgunHolder.gun;
    }
}
