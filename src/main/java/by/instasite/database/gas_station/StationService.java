package by.instasite.database.gas_station;

import java.util.List;

public interface StationService {
    Station getStationByAddress(String address);

    Station getStationByName(String name);

    void saveStation(Station station);

    void updateStation(int id, String name, String address);

    void deleteStation(int id);

    List<Station> findAll();
}