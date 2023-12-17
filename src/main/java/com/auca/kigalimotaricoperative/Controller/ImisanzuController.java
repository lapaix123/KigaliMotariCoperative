package com.auca.kigalimotaricoperative.Controller;

import com.auca.kigalimotaricoperative.model.Imisanzu;
import com.auca.kigalimotaricoperative.model.Motari;
import com.auca.kigalimotaricoperative.service.ImisanzuService;
import com.auca.kigalimotaricoperative.service.MotariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ImisanzuController {

    @Autowired
    private ImisanzuService imisanzuService;

    @GetMapping("/imisanzu")
    public String allImisanzu(Model model) {
        Imisanzu imisanzu = new Imisanzu();
        List<Imisanzu> imisanzus = imisanzuService.getAllImisanzus();
        model.addAttribute("imisanzu", imisanzu);
        model.addAttribute("imisanzus", imisanzus);


        return "imisanzu";
    }

    @PostMapping("/newImisanzu")
    public String newImisanzu(Imisanzu imisanzu, Model model) {
        Imisanzu savedImisanzu = imisanzuService.createImisanzu(imisanzu);
        return "redirect:/imisanzu";
    }
    @Autowired
private MotariService motariService;
    @GetMapping("/imisanzuForm")
    public String showCreateForm(Model model) {
        model.addAttribute("imisanzu", new Imisanzu());
        model.addAttribute("motari",new Motari());
        model.addAttribute("motaris",motariService.getAllMotaris());
        return "imisanzuForm";
    }

    @GetMapping("/imisanzuEdit/{imisanzuId}")
    public String showEdit(@PathVariable Integer imisanzuId, Model model) {
        Imisanzu imisanzu = imisanzuService.getImisanzuById(imisanzuId);

        model.addAttribute("imisanzu", imisanzu);
        return "redirect:/imisanzu";
    }

    @GetMapping("/imisanzuDelete/{imisanzuId}")
    public String deleteImisanzu(@PathVariable Integer imisanzuId) {
        imisanzuService.deleteImisanzu(imisanzuId);
        return "redirect:/imisanzu";
    }
}
