package by.instasite.controllers;

import by.instasite.database.user.User;
import by.instasite.database.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private UserService service;

    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String MainPage(Model model) {
        List<User> users = service.findAll();
        model.addAttribute("users", users);
        return "index";
    }
}
