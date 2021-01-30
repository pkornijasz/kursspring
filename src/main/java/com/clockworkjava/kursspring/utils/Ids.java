package com.clockworkjava.kursspring.utils;

import java.util.Set;

public class Ids {


    public static int getNewId(Set<Integer> keySoFar) {
        if (keySoFar.isEmpty()) {
            return 0;
        } else {
            Integer id = keySoFar.stream().reduce(Integer::max).get();
            return ++id;
        }
    }
}
