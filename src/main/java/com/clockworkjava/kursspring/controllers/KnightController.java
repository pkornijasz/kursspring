package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.components.TimeComponent;
import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.services.KnightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class KnightController {

    final KnightService service;
    final TimeComponent timeComponent;
    final PlayerInformation playerInformation;

    public KnightController(KnightService service, TimeComponent timeComponent, PlayerInformation playerInformation) {
        this.service = service;
        this.timeComponent = timeComponent;
        this.playerInformation = playerInformation;
    }

    @GetMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knights";
    }

    @GetMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knightform";
    }

    @GetMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = service.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knight";
    }

    @PostMapping(value = "/knights")
    public String saveKnight(@Valid Knight knight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("There were errors!");
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
            });
            return "knightform";
        } else {
            service.saveKnight(knight);
            return "redirect:/knights";
        }
    }

    @GetMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        service.deleteKnight(id);
        return "redirect:/knights";
    }
}
