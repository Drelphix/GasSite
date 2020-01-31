package by.instasite.database.discount_card;

import javax.persistence.*;


@Entity
@Table(name = "Discount_card")
public class Card {
    @Id
    @Column(name = "ID_card")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Discount")
    private int discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}