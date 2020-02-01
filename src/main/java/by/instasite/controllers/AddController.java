package by.instasite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddController {
    @GetMapping(value = "/add/client")
    public String AddClient(Model model) {
        return "add/client";
    }
}
