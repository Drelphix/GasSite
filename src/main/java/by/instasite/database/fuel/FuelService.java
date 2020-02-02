package by.instasite.database.fuel;

import by.instasite.database.gas_station.Station;

import java.util.List;

public interface FuelService {
    List<Fuel> getFuelByName(String fuelName);

    Fuel getFuelById(int id);

    void addFuel(Fuel fuel);

    void updateFuel(int id, String fuelName, String description, double price, Station station);

    void deleteFuel(int id);

    List<Fuel> findAll();
}