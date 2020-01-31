package by.instasite.database.price;

import javax.persistence.*;


@Entity
@Table(name = "Price")
public class Price {

    @Id
    @Column(name = "ID_Price")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ID_Zapravka")
    private int idStation;

    @Column(name = "ID_Fuel")
    private int idFuel;

    @Column(name = "Price")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public int getIdFuel() {
        return idFuel;
    }

    public void setIdFuel(int idFuel) {
        this.idFuel = idFuel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
