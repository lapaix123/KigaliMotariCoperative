package com.auca.kigalimotaricoperative.Controller;

import com.auca.kigalimotaricoperative.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private Adminserevice adminserevice;
    @GetMapping("/admin")
    public String allAdmins(Model model){
        Admin admin= new Admin();
        List<Admin> admins=adminserevice.getAdminList();
        model.addAttribute("admin",admin);
        model.addAttribute("admins",admins);

        return "admin";
    }
    @PostMapping("/nesAdmin")
    public String newAdmin(Admin admin,Model model){
      Admin admin1=adminserevice.newAdmin(admin)  ;
      return "redirect:/admin";
    }


}
