package by.instasite.controllers;

import by.instasite.database.client.ClientService;
import by.instasite.database.discount_card.CardService;
import by.instasite.database.employee.Employee;
import by.instasite.database.employee.EmployeeService;
import by.instasite.database.franchise.FranchiseService;
import by.instasite.database.fuel.FuelService;
import by.instasite.database.gas_station.Station;
import by.instasite.database.gas_station.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteController {
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

    @PostMapping(value = "/delete/employee")
    public String SaveEditedEmployee(Model model, @ModelAttribute Employee employee, @ModelAttribute Station station) {
        try {
            employeeService.deleteEmployee(employee.getId());
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка удаления, попробуйте еще раз");
            return "redirect:/add/employee";
        }
        return "redirect:/employee";
    }
}
