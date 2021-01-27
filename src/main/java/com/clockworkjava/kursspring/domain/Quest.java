package com.clockworkjava.kursspring.domain;

import org.springframework.stereotype.Component;

@Component
public class Quest {
    private String description;

    public Quest() {
        this.description = "Uratuj księżniczkę";
    }

    @Override
    public String toString() {
        return description;
    }
}
