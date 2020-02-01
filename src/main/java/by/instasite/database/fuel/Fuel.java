package by.instasite.database.fuel;

import by.instasite.database.price.Price;

import javax.persistence.*;


@Entity
@Table(name = "Fuel")
public class Fuel {
    @Id
    @Column(name = "idFuel")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "idPrice")
    private Price price;


    @Column(name = "Name")
    private String fuelName;

    @Column(name = "Description")
    private String description;


    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Fuel(Price price, String fuelName, String description) {
        this.price = price;
        this.fuelName = fuelName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}