package com.clockworkjava.kursspring.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Knight {
    private int id;
    @NotNull
    @Size(min = 2, max = 40, message = "Imię rycerza musi mieć od 2 do 40 znaków!")
    private String name;
    @NotNull
    @Range(min = 18, max = 60, message = "Wiek rycerza tylko z zakresu od 18 do 60 lat!")
    private int age;
    private int level;
    private Quest quest;

    public Knight() {
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        quest.setStarted(true);
        this.quest = quest;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + name + " (" + age + "). Ma za zadanie: " + quest;
    }
}
