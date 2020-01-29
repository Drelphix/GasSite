package by.instasite.controllers;

import by.instasite.database.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private UserService service;

    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/settings")
    public String UserAccount(Model model) {
        return "user_settings";
    }

}
