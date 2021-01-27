package com.clockworkjava.kursspring.domain;

import com.clockworkjava.kursspring.domain.Castle;
import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.Quest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CastleTest {

    @Test
    public void castleToStringMessage() {
        Knight knight = new Knight("Lancelot", 29);
        knight.setQuest(new Quest());
        Castle castle = new Castle(knight, "Castle Black");
        String except = "Znajduje się tu zamek o nazwie Castle Black. Zamieszkały przez rycerza Rycerz o imieniu Lancelot (29). Zadanie: Uratuj księżniczkę.";
        assertEquals(except, castle.toString());
    }
}
