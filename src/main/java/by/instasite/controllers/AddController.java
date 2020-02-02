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
import by.instasite.database.price.Price;
import by.instasite.database.price.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddController {
    private StationService stationService;
    private EmployeeService employeeService;
    private FuelService fuelService;
    private PriceService priceService;
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

    @Autowired
    public void setPriceService(PriceService service) {
        this.priceService = service;
    }

    @GetMapping(value = "/add/client")
    public String AddClient(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("card", new Card());
        return "add/client";
    }

    @GetMapping(value = "/add/card")
    public String AddCard(Model model) {
        model.addAttribute("card");
        return "add/card";
    }

    @GetMapping(value = "/add/employee")
    public String AddEmployee(Model model) {
        model.addAttribute("employee");
        return "add/employee";
    }

    @GetMapping(value = "/add/fuel")
    public String AddFuel(Model model) {
        model.addAttribute("fuel", new Fuel());
        model.addAttribute("stations", stationService.findAll());
        model.addAttribute("station", new Station());
        model.addAttribute("price", new Price());
        return "add/fuel";
    }

    @GetMapping(value = "/add/station")
    public String AddStation(Model model) {
        model.addAttribute("station", new Station());
        model.addAttribute("franchise", new Franchise());
        model.addAttribute("franchises", franchiseService.findAll());
        return "add/station";
    }

    @PostMapping(value = "/add/client")
    public String SaveClient(Model model, @ModelAttribute Card card, @ModelAttribute Client client) {
        try {
            client.setCard(card);
            cardService.addCard(card);
            clientService.saveClient(client);
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка добавления пользователя, попробуйте еще раз");
            return "/add/client";
        }
        return "redirect:/client";
    }

    @PostMapping(value = "/add/franchise")
    public String SaveFranchise(Model model, @ModelAttribute Franchise franchise) {
        try {

            franchiseService.saveFranchise(franchise);
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка добавления франшизы, попробуйте еще раз");
            return "/add/franchise";
        }
        return "redirect:/franchise";
    }

    @PostMapping(value = "/add/station")
    public String SaveStation(Model model, @ModelAttribute Franchise franchise, @ModelAttribute Station station) {
        try {
            // stationService.saveStation(franchise,station);
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка добавления франшизы, попробуйте еще раз");
            return "/add/franchise";
        }
        return "redirect:/franchise";
    }

    @PostMapping(value = "/add/fuel")
    public String SaveFuel(Model model, @ModelAttribute Station station, @ModelAttribute Fuel fuel, @ModelAttribute Price price) {
        try {
            fuel.setStation(stationService.getStationByName(station.getName()));
            fuelService.addFuel(fuel);
            priceService.addPrice(fuel, price);
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка добавления пользователя, попробуйте еще раз");
            return "/add/fuel";
        }
        return "redirect:/fuel";
    }
}

