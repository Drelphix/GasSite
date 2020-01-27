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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AuthController {
    private UserService service;

    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String Login(Model model, String error) {
        model.addAttribute("user", new User());
        model.addAttribute("error", error);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LoginSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        try {
            User databaseUser = service.getUserByUsername(user.getUsername());
            if (databaseUser.getPassword().equals(user.getPassword())) {
                return "redirect:/mainpage";
            } else {
                model.addAttribute("error", "Введенный логин или пароль неверен");
                return "login";
            }
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
    public String RegistrationSubmit(@ModelAttribute User user, RedirectAttributes redirectAttributes, Model model) {
        model.addAttribute("user", user);
        try {

            if (!user.getUsername().isEmpty()) {
                User temp = service.getUserByUsername(user.getUsername());
                if (!user.getPassword().isEmpty() && !temp.getUsername().equals(user.getUsername())) {
                    if (!user.getEmail().isEmpty()) {
                        temp = service.getUserByEmail(user.getEmail());
                        if (temp.getEmail().isEmpty()) {
                            service.saveUser(user);
                            return "redirect:/";
                        } else {
                            model.addAttribute("message", "Е-мейл занят");
                            return "register";
                        }
                    }

                } else {
                    model.addAttribute("message", "Логин или пароль неверен");
                    return "register";
                }
            } else {
                model.addAttribute("message", "Введите имя пользователя");
                return "register";
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "register";
    }

    @GetMapping(value = "/mainpage")
    public String MainPage(Model model) {
        List<User> users = service.findAll();
        model.addAttribute("users", users);
        return "mainpage";
    }
}
