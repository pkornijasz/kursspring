package com.clockworkjava.kursspring.utils;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IdsTest {
    @Test
    public void testEmptySet() {
        Integer result = Ids.getNewId(Collections.emptySet());
        assertEquals(0, java.util.Optional.of(result));
    }
    @Test
    public void testGenerateNewId() {
        Set<Integer> sample = new HashSet<>();
        sample.add(4);
        sample.add(5);
        sample.add(6);
        Integer result = Ids.getNewId(sample);
        assertEquals(7, java.util.Optional.of(result));
    }
}
