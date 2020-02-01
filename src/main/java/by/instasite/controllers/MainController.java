package by.instasite.controllers;

import by.instasite.database.client.ClientService;
import by.instasite.database.discount_card.CardService;
import by.instasite.database.employee.EmployeeService;
import by.instasite.database.fuel.FuelService;
import by.instasite.database.gas_station.StationService;
import by.instasite.database.price.PriceService;
import by.instasite.database.report.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
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

    @GetMapping(value = "/")
    public String MainPage(Model model) {

        return "index";
    }

    @GetMapping(value = "/add")
    public String addNewPage(Model model) {

        return "index";
    }
}
