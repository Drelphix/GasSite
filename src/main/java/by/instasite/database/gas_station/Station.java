package by.instasite.database.gas_station;

import by.instasite.database.employee.Employee;

import javax.persistence.*;


@Entity
@Table(name = "Station")
public class Station {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @OneToMany
    @JoinColumn(name = "idStation")
    private Employee employee;

    @OneToMany
    @JoinColumn(name = "idStation")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
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