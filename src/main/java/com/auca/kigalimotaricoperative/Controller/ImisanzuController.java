package com.auca.kigalimotaricoperative.Controller;

import com.auca.kigalimotaricoperative.model.Admin;
import com.auca.kigalimotaricoperative.model.Imisanzu;
import com.auca.kigalimotaricoperative.model.Motari;
import com.auca.kigalimotaricoperative.service.ImisanzuService;
import com.auca.kigalimotaricoperative.service.MotariService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ImisanzuController {

    @Autowired
    private ImisanzuService imisanzuService;

    @GetMapping("/imisanzu")
    public String allImisanzu(Model model,HttpSession session) {
        Admin collectAdmin=(Admin)  session.getAttribute("adminLogedIn");
        if(collectAdmin != null){
            model.addAttribute("collectAdmin",collectAdmin);
            Imisanzu imisanzu = new Imisanzu();
            List<Imisanzu> imisanzus = imisanzuService.getAllImisanzus();
            model.addAttribute("imisanzu", imisanzu);
            model.addAttribute("imisanzus", imisanzus);


            return "imisanzu";
        }else {
            return "redirect:/";
        }

    }

    @PostMapping("/newImisanzu")
    public String newImisanzu(Imisanzu imisanzu, Model model) {
        Imisanzu savedImisanzu = imisanzuService.createImisanzu(imisanzu);
        return "redirect:/imisanzu";
    }
    @Autowired
private MotariService motariService;
    @GetMapping("/imisanzuForm")
    public String showCreateForm(Model model,HttpSession session) {
        Admin collectAdmin=(Admin)  session.getAttribute("adminLogedIn");
        if(collectAdmin != null){
            model.addAttribute("collectAdmin",collectAdmin);
            model.addAttribute("imisanzu", new Imisanzu());
            model.addAttribute("motari",new Motari());
            model.addAttribute("motaris",motariService.getAllMotaris());
            return "imisanzuForm";
        }else {
            return "redirect:/";
        }

    }

    @GetMapping("/imisanzuEdit/{imisanzuId}")
    public String showEdit(@PathVariable Integer imisanzuId, Model model,HttpSession session) {
        Admin collectAdmin=(Admin)  session.getAttribute("adminLogedIn");
        if(collectAdmin != null){
            model.addAttribute("collectAdmin",collectAdmin);
            Imisanzu imisanzu = imisanzuService.getImisanzuById(imisanzuId);

            model.addAttribute("imisanzu", imisanzu);
            return "redirect:/imisanzu";
        }else {
            return "redirect:/";
        }

    }

    @GetMapping("/imisanzuDelete/{imisanzuId}")
    public String deleteImisanzu(@PathVariable Integer imisanzuId, Model model, HttpSession session) {
        Admin collectAdmin=(Admin)  session.getAttribute("adminLogedIn");
        if(collectAdmin != null){
            model.addAttribute("collectAdmin",collectAdmin);
            imisanzuService.deleteImisanzu(imisanzuId);
            return "redirect:/imisanzu";
        }else {
            return "redirect:/";
        }

    }
}
