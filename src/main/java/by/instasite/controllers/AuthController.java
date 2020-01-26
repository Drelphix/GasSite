package by.instasite.controllers;

import by.instasite.database.user.User;
import by.instasite.database.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
    private UserService service;

    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String Login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LoginSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        try {
            String username = user.getUsername();
            System.out.println("\n username:" + username);
            User databaseUser = service.getUserByUsername(username);
            System.out.println(databaseUser.getUsername());
            String password = user.getPassword();
            if (databaseUser.getPassword().equals(password)) {
                return "mainpage";
            } else return "login";
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "register";

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String Registration(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String RegistrationSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);

        return "redirect:/";
    }

    @RequestMapping(value = "/mainpage", method = RequestMethod.GET)
    public String MainPage(Model model) {
        model.addAttribute("users", service.findAll());
        return "mainpage";
    }
}
