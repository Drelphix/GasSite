package by.instasite.database.price;

import javax.persistence.*;


@Entity
@Table(name = "Price")
public class Price {

    @Id
    @Column(name = "idPrice")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Price")
    private double price;

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
}
