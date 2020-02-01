package by.instasite.database.gas_station;

import by.instasite.database.employee.Employee;
import by.instasite.database.fuel.Fuel;
import by.instasite.database.report.Franchise;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Station")
public class Station {
    @Id
    @Column(name = "idStation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> employee;

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Fuel> fuel;

    @ManyToOne
    @ElementCollection
    @JoinColumn(name = "idFranchise")
    private Franchise franchise;


    public Station() {
    }

    public Station(String name, String address, Set<Employee> employee, Set<Fuel> fuel, Franchise franchise) {
        this.name = name;
        this.address = address;
        this.employee = employee;
        this.fuel = fuel;
        this.franchise = franchise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public Set<Fuel> getFuel() {
        return fuel;
    }

    public void setFuel(Set<Fuel> fuel) {
        this.fuel = fuel;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
}