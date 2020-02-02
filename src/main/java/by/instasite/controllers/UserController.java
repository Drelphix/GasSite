package by.instasite.controllers;

import by.instasite.database.user.User;
import by.instasite.database.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value = "/edit/admin")
    public String getEditedUser(Model model, @RequestParam(name = "id") int id) {
        User user = service.getUserById(id);
        model.addAttribute("client", user);
        return "/edit/admin";
    }

    @PostMapping(value = "/edit/admin")
    public String saveEditedUser(Model model, @ModelAttribute User user) {
        User update = service.getUserById(user.getId());
        user.setPassword(update.getPassword());
        service.saveUser(user);
        return "/admin";
    }

}
