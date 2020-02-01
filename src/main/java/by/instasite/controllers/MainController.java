package by.instasite.controllers;

import by.instasite.database.employee.EmployeeService;
import by.instasite.database.fuel.Fuel;
import by.instasite.database.fuel.FuelService;
import by.instasite.database.gas_station.StationService;
import by.instasite.database.price.Price;
import by.instasite.database.price.PriceService;
import by.instasite.database.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {
    private StationService stationService;
    private EmployeeService employeeService;
    private FuelService fuelService;
    private PriceService priceService;

    @Autowired
    public void setStationService(StationService service) {
        this.stationService = service;
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
    public void setPriceService(PriceService service) {
        this.priceService = service;
    }

    @GetMapping(value = "/")
    public String MainPage(Model model) {
        return "index";
    }

    @GetMapping(value = "/add")
    public String addNewPage(Model model) {
        Report report = new Report();
        Set<Fuel> fuels = new HashSet<>();
        Fuel fuel = new Fuel();
        Price price = new Price();

        price.setPrice(10.5);
        priceService.addPrice(price);
        fuel.setPrice(price);


        report.setClient();
        return "index";
    }
}
