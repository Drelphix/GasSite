package by.instasite.database.price;

import by.instasite.database.fuel.Fuel;
import by.instasite.database.gas_station.Station;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Price")
public class Price {

    @Id
    @Column(name = "idPrice")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany
    @JoinColumn(name = "idStation")
    private Set<Station> idStation;

    @OneToOne
    @JoinColumn(name = "idFuel")
    private Fuel idFuel;

    @Column(name = "Price")
    private double price;

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

    public Fuel getIdFuel() {
        return idFuel;
    }

    public void setIdFuel(Fuel idFuel) {
        this.idFuel = idFuel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
