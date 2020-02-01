package by.instasite.database.franchise;

import by.instasite.database.client.Client;
import by.instasite.database.gas_station.Station;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Franchise")
public class Franchise {
    @Id
    @Column(name = "idFranchise")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Station> stations;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Client> client;

    public Franchise() {

    }

    public Franchise(Set<Station> stations, String name, Set<Client> client) {
        this.stations = stations;
        this.name = name;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Station> getStations() {
        return stations;
    }

    public void setStations(Set<Station> stations) {
        this.stations = stations;
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