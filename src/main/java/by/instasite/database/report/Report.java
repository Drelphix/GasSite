package by.instasite.database.report;

import by.instasite.database.client.Client;
import by.instasite.database.employee.Employee;
import by.instasite.database.fuel.Fuel;
import by.instasite.database.gas_station.Station;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Report")
public class Report {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany
    @JoinColumn(name = "idStation")
    private Set<Station> idStation;

    @OneToMany
    @JoinColumn(name = "idFuel")
    private Set<Fuel> fuel;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "idEmployee")
    private Set<Employee> employee;

    @OneToMany
    @JoinColumn(name = "idClient")
    private Set<Client> client;

    public Report(Set<Station> idStation, Set<Fuel> fuel, String name, Set<Employee> employee, Set<Client> client) {
        this.idStation = idStation;
        this.fuel = fuel;
        this.name = name;
        this.employee = employee;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Station> getIdStation() {
        return idStation;
    }

    public void setIdStation(Set<Station> idStation) {
        this.idStation = idStation;
    }

    public Set<Fuel> getFuel() {
        return fuel;
    }

    public void setFuel(Set<Fuel> fuel) {
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public Set<Client> getClient() {
        return client;
    }

    public void setClient(Set<Client> client) {
        this.client = client;
    }
}