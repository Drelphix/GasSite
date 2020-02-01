package by.instasite.database.discount_card;

import javax.persistence.*;


@Entity
@Table(name = "Discount")
public class Card {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Discount")
    private int discount;


    public Card() {
    }

    public Card(int discount) {
        this.discount = discount;
    }

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