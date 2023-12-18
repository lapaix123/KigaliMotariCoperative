package com.auca.kigalimotaricoperative.Controller;

import com.auca.kigalimotaricoperative.model.Admin;
import com.auca.kigalimotaricoperative.model.Motari;
import com.auca.kigalimotaricoperative.model.User;
import com.auca.kigalimotaricoperative.service.MotariService;
import com.auca.kigalimotaricoperative.service.UserService;
import jakarta.servlet.http.HttpSession;
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
    public String allMotaris(Model model, HttpSession session) {
        Admin collectAdmin=(Admin)  session.getAttribute("adminLogedIn");
        if(collectAdmin != null){
            model.addAttribute("collectAdmin",collectAdmin);
            Motari motari = new Motari();
            List<Motari> motaris = motariService.getAllMotaris();
            model.addAttribute("motari", motari);
            model.addAttribute("motaris", motaris);

            return "motari";
        }else {
            return "redirect:/";
        }

    }

    @PostMapping("/newMotari")
    public String newMotari(Motari motari, Model model) {
        Motari savedMotari = motariService.createMotari(motari);
        return "redirect:/motari";
    }

    @GetMapping("/motariForm")
    public String showCreateForm(Model model,HttpSession session) {
        Admin collectAdmin=(Admin)  session.getAttribute("adminLogedIn");
        if(collectAdmin != null){
            model.addAttribute("collectAdmin",collectAdmin);
            model.addAttribute("motari", new Motari());
            return "motariForm";
        }else {
            return "redirect:/";
        }

    }

    @GetMapping("/motariEdit/{motariId}")
    public String showEdit(@PathVariable Integer motariId, Model model,HttpSession session) {
        Admin collectAdmin=(Admin)  session.getAttribute("adminLogedIn");
        if(collectAdmin != null){
            model.addAttribute("collectAdmin",collectAdmin);
            Motari motari = motariService.getMotariById(motariId);

            model.addAttribute("motari", motari);
            return "redirect:/motari";
        }else {
            return "redirect:/";
        }

    }

    @GetMapping("/motariDelete/{motariId}")
    public String deleteMotari(@PathVariable Integer motariId,HttpSession session,Model model) {
        Admin collectAdmin=(Admin)  session.getAttribute("adminLogedIn");
        if(collectAdmin != null){
            model.addAttribute("collectAdmin",collectAdmin);
            Motari motari = motariService.getMotariById(motariId);

            motariService.deleteMotari(motariId);
            return "redirect:/motari";
        }else {
            return "redirect:/";
        }

    }

    ////////////////////////// new motari form //////////////////////////
    @GetMapping("/motariUserForm")
    public String newMotariUser(Model model){
        model.addAttribute("user",new User());
        return "newMotariUser";

    }
    @Autowired
    private UserService userService;
    @PostMapping("/newUser")
    public String newUser(User user,Model model){
        Motari motari= motariService.getMotariById(user.getMotari().getMotariId());
        if(motari != null){
            User newUser= userService.findUserById(user.getMotari().getMotariId());
            if(newUser != null){
                model.addAttribute("message","Motari has account Contact adminstrator");
                return "newMotariUser";

            }  else {
                userService.createUser(user);
                return "redirect:/";
            }
        }else {
            model.addAttribute("message","Motari Not found");
            return "newMotariUser";

        }



    }


}
