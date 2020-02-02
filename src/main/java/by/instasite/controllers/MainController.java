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
import by.instasite.database.price.Price;
import by.instasite.database.price.PriceService;
import by.instasite.tableviews.MainView;
import by.instasite.tableviews.PriceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public String ShowMainPage(Model model) {
        List<MainView> mainViews = new ArrayList<>();
        for (Franchise franchise : franchiseService.findAll()) {
            for (Station station : franchise.getStations()) {
                for (Fuel fuel : station.getFuel()) {
                    MainView mainView = new MainView(franchise.getName(), station.getName(), station.getAddress(), fuel.getFuelName(), fuel.getPrice().getPrice());
                    mainViews.add(mainView);
                }
            }
        }
        model.addAttribute("rows", mainViews);
        return "index";
    }


    @GetMapping(value = "/client")
    public String ShowClientTable(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "index";
    }

    @GetMapping(value = "/price")
    public String ShowFuelTable(Model model) {
        List<PriceView> priceViewList = new ArrayList<>();
        for (Fuel fuel : fuelService.findAll()) {
            PriceView priceView = new PriceView(fuel.getFuelName(), fuel.getDescription(), fuel.getPrice().getPrice());
            priceViewList.add(priceView);
        }
        model.addAttribute("fuels", priceViewList);
        return "index";
    }


    @GetMapping(value = "/employee")
    public String ShowEmployeeTable(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "index";
    }

    @GetMapping(value = "/franchise")
    public String ShowFranchiseTable(Model model) {

        model.addAttribute("franchises", franchiseService.findAll());
        return "index";
    }

    @GetMapping(value = "/station")
    public String ShowStationTable(Model model) {
        model.addAttribute("stations", stationService.findAll());
        return "index";
    }


    @GetMapping(value = "/test")
    public String addNewPage(Model model) {
        Card card = new Card(10);
        cardService.addCard(card);
        Franchise franchise = new Franchise(null, "ООО Лукоил", null);

        franchiseService.saveFranchise(franchise);

        Client client = new Client("Алексей", "Демешко", "Витебск", "+141434324", card, franchise);
        clientService.saveClient(client);
        Set<Client> clients = new HashSet<>();
        clients.add(client);
        Set<Franchise> franchises = new HashSet<>();

        franchises.add(franchise);

        Station station = new Station("Лукоил", "пр-т Строителей", null, null, franchise);
        Set<Station> stations = new HashSet<>();
        stations.add(station);
        stationService.saveStation(franchise, station);


        Employee employee = new Employee("Лешка", "Дешешко", "Витебск", "+37525595959", station);
        Employee employee1 = new Employee("Леська", "Юрьевна", "Минск", "+37543242344", station);
        employeeService.addEmployee(station, employee);
        employeeService.addEmployee(station, employee1);

        Fuel fuel = new Fuel(null, "AI-92", "Bred", station);
        Fuel fuel1 = new Fuel(null, "AI-95", "Bred", station);
        fuelService.addFuel(station, fuel);
        fuelService.addFuel(station, fuel1);

        Set<Fuel> fuels = new HashSet<>();

        Price price = new Price(10.5, fuel);
        Price price1 = new Price(20.5, fuel1);
        priceService.addPrice(fuel, price);
        priceService.addPrice(fuel, price1);

        fuels.add(fuel);
        fuels.add(fuel1);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee);
        return "index";
    }
}
