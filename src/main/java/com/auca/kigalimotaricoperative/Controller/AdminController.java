package com.auca.kigalimotaricoperative.Controller;

import com.auca.kigalimotaricoperative.model.Admin;
import com.auca.kigalimotaricoperative.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminserevice;
    @GetMapping("/admin")
    public String allAdmins(Model model){
        Admin admin= new Admin();
        List<Admin> admins=adminserevice.getAllAdmins();
        model.addAttribute("admin",admin);
        model.addAttribute("admins",admins);

        return "admin";
    }
    @PostMapping("/newAdmin")
    public String newAdmin(Admin admin,Model model){
      Admin admin1=adminserevice.createAdmin(admin)  ;
      return "redirect:/admin";
    }
    @GetMapping("/adminForm")
    public String showCreateForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminForm";
    }
    @GetMapping("/adminEdit/{adminId}")
    public String showEdit(@PathVariable Integer adminId, Model model) {
        Admin optionalAdmin = adminserevice.getAdminById(adminId);

            model.addAttribute("admin", optionalAdmin);
            return "redirect:/admin";
    }
    @GetMapping("/delete/{adminId}")
    public String deleteAdmin(@RequestParam Integer id){
        adminserevice.deleteAdmin(id);

        return "redirect:/admin";
    }

}
