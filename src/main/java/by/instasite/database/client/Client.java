package by.instasite.database.client;

import by.instasite.database.discount_card.Card;
import by.instasite.database.report.Franchise;

import javax.persistence.*;


@Entity
@Table(name = "Client")
public class Client {
    @Id
    @Column(name = "idClient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Address")
    private String address;

    @Column(name = "Telephone")
    private String telephone;

    @OneToOne
    @JoinColumn(name = "idCard")
    private Card card;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFranchise")
    private Franchise franchise;

    public Client() {
    }

    public Client(String name, String surname, String address, String telephone, Card card, Franchise franchise) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.card = card;
        this.franchise = franchise;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
}