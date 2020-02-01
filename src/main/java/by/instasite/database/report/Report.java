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


}