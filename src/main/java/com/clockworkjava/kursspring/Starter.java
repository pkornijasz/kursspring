package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import com.clockworkjava.kursspring.services.QuestService;
import com.clockworkjava.kursspring.utils.Role;
import com.clockworkjava.kursspring.utils.RoleRepository;
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

    final PlayerInformationRepository playerInformationRepository;

    final RoleRepository roleRepository;

    public Starter(KnightRepository knightRepository, QuestRepository questRepository, QuestService questService, PlayerInformationRepository playerInformationRepository, RoleRepository roleRepository) {
        this.knightRepository = knightRepository;
        this.questRepository = questRepository;
        this.questService = questService;
        this.playerInformationRepository = playerInformationRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception{
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival", 32);

        PlayerInformation playerInformation1 = new PlayerInformation("user1", "user1");
        playerInformationRepository.createPlayerInformation(playerInformation1);

        PlayerInformation playerInformation2 = new PlayerInformation("user2", "user2");
        playerInformationRepository.createPlayerInformation(playerInformation2);

        Role user1RoleUSER = new Role("user1", "USER");
        Role user2RoleUSER = new Role("user2", "USER");
        Role user2RoleADMIN = new Role("user2", "ADMIN");

        roleRepository.persistRole(user1RoleUSER);
        roleRepository.persistRole(user2RoleUSER);
        roleRepository.persistRole(user2RoleADMIN);

        questService.assignRandomQuest("Percival");
    }
}
