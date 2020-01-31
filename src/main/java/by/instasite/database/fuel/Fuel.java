package by.instasite.database.fuel;

import javax.persistence.*;


@Entity
@Table(name = "Fuel")
public class Fuel {
    @Id
    @Column(name = "ID_Fuel")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Fuel_Name")
    private String fuelName;

    @Column(name = "Description_Fuel")
    private String description;

    @Column(name = "Price")
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}