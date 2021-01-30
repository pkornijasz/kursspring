package com.clockworkjava.kursspring.domain;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class QuestTest {

    @Test
    public void settingStartedFlagToTrueShouldSetStartDate() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);
        assertNotNull(quest.startDate);
    }

    @Test
    public void questShouldBeCompleted() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);
        quest.lengthInSeconds = - 60;
        assertTrue(quest.isCompleted());
        assertTrue(quest.isCompleted());
    }

    @Test
    public void questShouldNotBeCompleted() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);
        quest.lengthInSeconds = 20000;
        assertFalse(quest.isCompleted());
        assertFalse(quest.isCompleted());
    }
}
