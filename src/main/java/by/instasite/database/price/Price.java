package by.instasite.database.price;

import by.instasite.database.fuel.Fuel;

import javax.persistence.*;


@Entity
@Table(name = "Price")
public class Price {

    @Id
    @Column(name = "idPrice")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Price")
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFuel")
    private Fuel fuel;

    public Price() {
    }

    public Price(double price, Fuel fuel) {
        this.price = price;
        this.fuel = fuel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
}
