package by.instasite.controllers;

import by.instasite.database.client.Client;
import by.instasite.database.client.ClientService;
import by.instasite.database.discount_card.Card;
import by.instasite.database.discount_card.CardService;
import by.instasite.database.employee.Employee;
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

@Controller
public class AddController {
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


    @GetMapping(value = "/add/client")
    public String AddClient(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("card", new Card());
        model.addAttribute("franchises", franchiseService.findAll());
        model.addAttribute("franchise", new Franchise());
        return "add/client";
    }

    @GetMapping(value = "/add/franchise")
    public String AddFranchise(Model model) {
        model.addAttribute("franchise", new Franchise());
        return "add/franchise";
    }


    @GetMapping(value = "/add/employee")
    public String AddEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("stations", stationService.findAll());
        model.addAttribute("station", new Station());
        return "add/employee";
    }

    @GetMapping(value = "/add/fuel")
    public String AddFuel(Model model) {
        model.addAttribute("fuel", new Fuel());
        model.addAttribute("stations", stationService.findAll());
        model.addAttribute("station", new Station());
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
    public String SaveClient(Model model, @ModelAttribute Card card, @ModelAttribute Client client, @ModelAttribute Franchise franchise) {
        try {
            Franchise updatedFran = franchiseService.getById(franchise.getId());
            client.setCard(card);
            client.setFranchise(franchise);
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
            return "redirect:/add/franchise";
        }
        return "redirect:/franchise";
    }

    @PostMapping(value = "/add/station")
    public String SaveStation(Model model, @ModelAttribute Station station, @ModelAttribute Franchise franchise) {
        try {
            station.setFranchise(franchiseService.getById(franchise.getId()));
            stationService.saveStation(station);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ошибка добавления франшизы, попробуйте еще раз");
            return "redirect:/add/station";
        }
        return "redirect:/station";
    }

    @PostMapping(value = "/add/fuel")
    public String SaveFuel(Model model, @ModelAttribute Station station, @ModelAttribute Fuel fuel) {
        try {
            fuel.setStation(stationService.getStationByName(station.getName()));
            fuelService.addFuel(fuel);
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка добавления пользователя, попробуйте еще раз");
            return "redirect:/add/fuel";
        }
        return "redirect:/price";
    }

    @PostMapping(value = "/add/employee")
    public String SaveEmployee(Model model, @ModelAttribute Employee employee, @ModelAttribute Station station) {
        try {
            employee.setStation(stationService.getStationById(station.getId()));
            employeeService.addEmployee(employee);
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка добавления франшизы, попробуйте еще раз");
            return "redirect:/add/employee";
        }
        return "redirect:/employee";
    }
}

