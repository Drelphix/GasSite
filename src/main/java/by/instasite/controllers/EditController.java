package by.instasite.controllers;

import by.instasite.database.client.Client;
import by.instasite.database.client.ClientService;
import by.instasite.database.discount_card.Card;
import by.instasite.database.discount_card.CardService;
import by.instasite.database.employee.EmployeeService;
import by.instasite.database.franchise.Franchise;
import by.instasite.database.franchise.FranchiseService;
import by.instasite.database.fuel.Fuel;
import by.instasite.database.fuel.FuelService;
import by.instasite.database.gas_station.Station;
import by.instasite.database.gas_station.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class EditController {

    private StationService stationService;
    private EmployeeService employeeService;
    private FuelService fuelService;
    private CardService cardService;
    private ClientService clientService;
    private FranchiseService franchiseService;

    @Autowired
    public void setStationService(StationService service) {
        this.stationService = service;
    }

    @Autowired
    public void setFranchiseService(FranchiseService service) {
        this.franchiseService = service;
    }

    @Autowired
    public void setEmployeeService(EmployeeService service) {
        this.employeeService = service;
    }

    @Autowired
    public void setFuelService(FuelService service) {
        this.fuelService = service;
    }

    @Autowired
    public void setCardService(CardService service) {
        this.cardService = service;
    }

    @Autowired
    public void setClientService(ClientService service) {
        this.clientService = service;
    }



    @GetMapping(value = "/edit/client")
    public String EditClient(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("card", new Card());
        return "add/client";
    }


    @GetMapping(value = "/edit/employee")
    public String EditEmployee(Model model) {
        model.addAttribute("employee");
        return "add/employee";
    }

    @GetMapping(value = "/edit/fuel")
    public String EditFuel(Model model, @RequestAttribute int id) {
        model.addAttribute("fuel", new Fuel());
        model.addAttribute("stations", stationService.findAll());
        model.addAttribute("station", new Station());
        return "add/fuel";
    }

    @GetMapping(value = "/edit/station")
    public String EditStation(Model model) {
        model.addAttribute("station", new Station());
        model.addAttribute("franchise", new Franchise());
        model.addAttribute("franchises", franchiseService.findAll());
        return "add/station";
    }

    @PostMapping(value = "/edit/client")
    public String EditClient(Model model, @ModelAttribute Card card, @ModelAttribute Client client) {
        try {
            client.setCard(card);
            cardService.addCard(card);
            clientService.saveClient(client);
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка добавления пользователя, попробуйте еще раз");
            return "redirect:/add/client";
        }
        return "redirect:/client";
    }

    @PostMapping(value = "/edit/franchise")
    public String SaveEditedFranchise(Model model, @ModelAttribute Franchise franchise) {
        try {
            franchiseService.saveFranchise(franchise);
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка редактирования франшизы, попробуйте еще раз");
            return "redirect:/add/franchise";
        }
        return "redirect:/franchise";
    }

    @PostMapping(value = "/edit/station")
    public String SaveEditedStation(Model model, @ModelAttribute Franchise franchise, @ModelAttribute Station station) {
        try {
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка редактирования станции, попробуйте еще раз");
            return "redirect:/station";
        }
        return "redirect:/station";
    }

    @PostMapping(value = "/edit/fuel")
    public String SaveEditedFuel(Model model, @ModelAttribute Station station, @ModelAttribute Fuel fuel) {
        try {
            fuel.setStation(stationService.getStationByName(station.getName()));
            fuelService.addFuel(fuel);
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка редактирования, попробуйте еще раз");
            return "redirect:/fuel";
        }
        return "redirect:/fuel";
    }

}
