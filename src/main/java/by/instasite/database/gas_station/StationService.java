package by.instasite.database.gas_station;

import by.instasite.database.report.Franchise;

import java.util.List;

public interface StationService {
    Station getStationByAddress(String address);
    List<Station> getStationsByName(String name);

    void saveStation(Franchise franchise, Station station);

    void updateStation(int id, String name, String address);

    void deleteStation(int id);

    List<Station> findAll();
}