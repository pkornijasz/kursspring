package com.clockworkjava.kursspring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    private int reward = 100;

    protected int lengthInSeconds = 10;

    private boolean started = false;

    private boolean completed = false;

    protected LocalDateTime startDate;

    public Quest() {
    }

    public Quest(String description) {
        this.description = description;
    }

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLength() {
        return lengthInSeconds;
    }

    public void setLength(int length) {
        this.lengthInSeconds = length;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if (started) this.startDate = LocalDateTime.now();
        this.started = started;
    }

    public boolean isCompleted() {
        if (this.completed) {
            return true;
        } else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime questEndTime = this.startDate.plusSeconds(this.lengthInSeconds);
            boolean isAfter = now.isAfter(questEndTime);
            if (isAfter) {
                this.completed = true;
            }
            return isAfter;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return description;
    }
}
