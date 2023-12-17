package com.auca.kigalimotaricoperative.Controller;

import com.auca.kigalimotaricoperative.model.Admin;
import com.auca.kigalimotaricoperative.model.User;
import com.auca.kigalimotaricoperative.service.AdminService;
import com.auca.kigalimotaricoperative.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        @RequestParam String userType,
                        Model model, HttpSession session) {

        if ("admin".equalsIgnoreCase(userType)) {
            Optional<Admin> admin= adminService.loginAdmin(email,password);
            if(admin.isPresent()){
                session.setAttribute("adminLogedIn",admin.get());
                return "redirect:/adminPage"; // Redirect to the admin home page
            }else {
                // Handle invalid motari credentials
                model.addAttribute("error", "Invalid Motari credentials");
                return "redirect:/"; // Redirect back to the login page with an error message
            }


        } else if ("motari".equalsIgnoreCase(userType)) {
            Optional<User> motari = userService.loginMotari(email, password);
            if (motari.isPresent()) {
                session.setAttribute("motari", motari.get());
                return "redirect:/motariHomePage"; // Redirect to the motari home page
            } else {
                // Handle invalid motari credentials
                model.addAttribute("error", "Invalid Motari credentials");
                return "redirect:/"; // Redirect back to the login page with an error message
            }

        } else {
            // Handle invalid user type
            model.addAttribute("error", "Invalid user type");
            return "redirect:/"; // Redirect back to the login page with an error message
        }
    }
}
