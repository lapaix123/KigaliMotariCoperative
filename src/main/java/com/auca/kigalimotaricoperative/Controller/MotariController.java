package com.auca.kigalimotaricoperative.controller;

import com.auca.kigalimotaricoperative.model.Motari;
import com.auca.kigalimotaricoperative.service.MotariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MotariController {

    @Autowired
    private MotariService motariService;

    @GetMapping("/motari")
    public String allMotaris(Model model) {
        Motari motari = new Motari();
        List<Motari> motaris = motariService.getAllMotaris();
        model.addAttribute("motari", motari);
        model.addAttribute("motaris", motaris);

        return "motari";
    }

    @PostMapping("/newMotari")
    public String newMotari(Motari motari, Model model) {
        Motari savedMotari = motariService.createMotari(motari);
        return "redirect:/motari";
    }

    @GetMapping("/motariForm")
    public String showCreateForm(Model model) {
        model.addAttribute("motari", new Motari());
        return "motariForm";
    }

    @GetMapping("/motariEdit/{motariId}")
    public String showEdit(@PathVariable String motariId, Model model) {
        Motari motari = motariService.getMotariById(motariId);

        model.addAttribute("motari", motari);
        return "redirect:/motari";
    }

    @GetMapping("/motariDelete/{motariId}")
    public String deleteMotari(@PathVariable String motariId) {
        motariService.deleteMotari(motariId);
        return "redirect:/motari";
    }
}
