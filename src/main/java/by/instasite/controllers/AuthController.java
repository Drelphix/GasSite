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

    @GetMapping(value = "/login-error")
    public String LoginError(Model model) {
        model.addAttribute("error", "Неверно введен логин или пароль");
        return "login";
    }

    @GetMapping(value = "/registration")
    public String Registration(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("repeat", "");
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String RegistrationSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        User userByUsername = service.getUserByUsername(user.getUsername());
        if (userByUsername != null) {
            model.addAttribute("message", "Имя пользователя занято");
            return "registration";
        } else {
            User userByEmail = service.getUserByEmail(user.getEmail());
            if (userByEmail != null) {
                model.addAttribute("message", "E-мейл уже занят");
                return "registration";
            } else {
                user.setActive(true);
                user.setRole("USER");
                service.saveUser(user);
                return "redirect:/login";
            }
        }
    }
}
