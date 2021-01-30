package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.services.KnightService;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    final KnightService knightService;
    final QuestService questService;
    final PlayerInformation playerInformation;

    public QuestController(KnightService knightService, QuestService questService, PlayerInformation playerInformation) {
        this.knightService = knightService;
        this.questService = questService;
        this.playerInformation = playerInformation;
    }

    @GetMapping("/assignquest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuests", notStartedQuests);
        return "assignquest";
    }

    @PostMapping("/assignquest")
    public String assignQuest(Knight knight, BindingResult result) {
        System.out.println(result);
        knightService.updateKnight(knight);
//        Quest quest = knight.getQuest();
//        questService.update(quest);
        return "redirect:/knights";
    }

    @GetMapping("/checkquests")
    public String checkQuests() {
        List<Knight> allKnights = knightService.getAllKnights();
        allKnights.forEach(knight -> knight.getQuest().isCompleted());
        int currentGold = playerInformation.getGold();
        playerInformation.setGold(currentGold + knightService.collectRewards());
        knightService.collectRewards();
        return "redirect:/knights";
    }

}
