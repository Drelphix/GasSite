package by.instasite.database.employee;

import by.instasite.database.gas_station.Station;

import javax.persistence.*;


@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "idEmployee")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Address")
    private String address;


    @Column(name = "Telephone")
    private String telephone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idStation")
    private Station station;


    public Employee() {
    }

    public Employee(String name, String surname, String address, String telephone, Station station) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.station = station;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}