package by.instasite.database.gas_station;

import by.instasite.database.employee.Employee;
import by.instasite.database.fuel.Fuel;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Station")
public class Station {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @OneToMany
    @ElementCollection
    @JoinColumn(name = "id")
    private Set<Employee> employee;

    @OneToMany
    @ElementCollection
    @JoinColumn(name = "id")
    private Set<Fuel> fuel;

    public Station(String name, String address, Set<Employee> employee, Set<Fuel> fuel) {
        this.name = name;
        this.address = address;
        this.employee = employee;
        this.fuel = fuel;
    }

    public Station() {
    }

    public Set<Fuel> getFuel() {
        return fuel;
    }

    public void setFuel(Set<Fuel> fuel) {
        this.fuel = fuel;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
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
}