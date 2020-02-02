package by.instasite.database.gas_station;

import by.instasite.database.franchise.Franchise;

import java.util.List;

public interface StationService {
    Station getStationByAddress(String address);

    Station getStationByName(String name);

    Station getStationById(int id);

    void saveStation(Station station);

    void updateStation(int id, String name, String address, Franchise franchise);

    void deleteStation(int id);

    List<Station> findAll();
}