package by.instasite.database.report;

import by.instasite.database.client.Client;
import by.instasite.database.gas_station.Station;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Franchise")
public class Franchise {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany
    @JoinColumn(name = "id")
    private Set<Station> idStation;

    @Column(name = "name")
    private String name;

    @ManyToMany
    private Set<Client> client;

    public Franchise() {
    }

    public Franchise(Set<Station> idStation, String name, Set<Client> client) {
        this.idStation = idStation;
        this.name = name;
        this.client = client;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Client> getClient() {
        return client;
    }

    public void setClient(Set<Client> client) {
        this.client = client;
    }
}