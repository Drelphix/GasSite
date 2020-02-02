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

    @GetMapping(value = "/add/card")
    public String AddCard(Model model) {
        return "add/card";
    }

    @GetMapping(value = "/add/employee")
    public String AddEmployee(Model model) {
        return "add/employee";
    }

    @GetMapping(value = "/add/fuel")
    public String AddFuel(Model model) {
        return "add/fuel";
    }

    @GetMapping(value = "/add/station")
    public String AddStation(Model model) {
        return "add/station";
    }
}

