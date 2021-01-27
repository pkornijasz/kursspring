package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.Castle;
import com.clockworkjava.kursspring.domain.Knight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class KursspringApplicationTests {

    @Autowired
    Knight knight;
    @Autowired
    Castle castle;

    @Test
    void contextLoads() {
    }

    @Test
    void testCastle() {
        String except = "Znajduje się tu zamek o nazwie Castle Black. Zamieszkały przez rycerza Rycerz o imieniu Lancelot (29). Zadanie: Uratuj księżniczkę.";
//        Castle castle = new Castle(knight);
        assertEquals(except, castle.toString());
    }

}
