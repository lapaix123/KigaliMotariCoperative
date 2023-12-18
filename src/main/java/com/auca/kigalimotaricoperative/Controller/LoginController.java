package com.auca.kigalimotaricoperative.Controller;

import com.auca.kigalimotaricoperative.model.Admin;
import com.auca.kigalimotaricoperative.model.Imisanzu;
import com.auca.kigalimotaricoperative.model.Motari;
import com.auca.kigalimotaricoperative.model.User;
import com.auca.kigalimotaricoperative.service.AdminService;
import com.auca.kigalimotaricoperative.service.ImisanzuService;
import com.auca.kigalimotaricoperative.service.MotariService;
import com.auca.kigalimotaricoperative.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private MotariService motariService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ImisanzuService imisanzuService;

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
                session.setAttribute("motari", email);

                Motari motari1= motariService.findByEmail(email);
                Imisanzu imisanzu = new Imisanzu();
                List<Imisanzu> imisanzus = imisanzuService.findImisanzuByMotari(motari1.getMotariId());
                if(imisanzus != null) {
                    model.addAttribute("imisanzu", imisanzu);
                    model.addAttribute("imisanzus", imisanzus);
                }

                return "motariHomePage"; // Redirect to the motari home page
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
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:/"; // Redirect back to the login page with an
    }
}
