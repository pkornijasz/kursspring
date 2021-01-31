package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    private final KnightRepository knightRepository;

    private final QuestRepository questRepository;

    private final QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    public Starter(KnightRepository knightRepository, QuestRepository questRepository, QuestService questService) {
        this.knightRepository = knightRepository;
        this.questRepository = questRepository;
        this.questService = questService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception{
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival", 32);

        playerInformationRepository.createPlayerInformation(new PlayerInformation());

        questService.assignRandomQuest("Percival");
    }
}
