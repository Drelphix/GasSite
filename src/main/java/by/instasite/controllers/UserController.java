package by.instasite.controllers;

import by.instasite.database.user.User;
import by.instasite.database.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private UserService service;

    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/settings")
    public String UserAccount(Model model) {
        model.addAttribute("client");
        return "user_settings";
    }

    @GetMapping(value = "/admin/add")
    public String ChangeUserInfo(Model model) {
        List<User> users = service.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping(value = "/admin")
    public String Administration(Model model) {
        List<User> users = service.findAll();
        model.addAttribute("users", users);
        return "index";
    }

}
