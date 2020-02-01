package by.instasite.database.fuel;

import by.instasite.database.gas_station.Station;
import by.instasite.database.price.Price;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Fuel")
public class Fuel {
    @Id
    @Column(name = "idFuel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "fuel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Price> price;

    @Column(name = "Name")
    private String fuelName;

    @Column(name = "Description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idStation")
    private Station station;

    public Fuel() {
    }

    public Fuel(Set<Price> price, String fuelName, String description, Station station) {
        this.price = price;
        this.fuelName = fuelName;
        this.description = description;
        this.station = station;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Price> getPrice() {
        return price;
    }

    public void setPrice(Set<Price> price) {
        this.price = price;
    }

    public String getFuelName() {
        return fuelName;
    }

    public void setFuelName(String fuelName) {
        this.fuelName = fuelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}