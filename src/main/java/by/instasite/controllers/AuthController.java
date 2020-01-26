package by.instasite.controllers;

import by.instasite.database.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(Model model) {
        model.addAttribute("login", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LoginSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("login", user);
        return "mainpage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String Registration(Model model) {
        model.addAttribute("login", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String RegistrationSubmit(@ModelAttribute User register, Model model) {
        model.addAttribute("login", register);
        return "mainpage";
    }
}
