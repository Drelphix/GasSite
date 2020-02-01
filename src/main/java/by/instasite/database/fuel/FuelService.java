package by.instasite.database.fuel;

import by.instasite.database.gas_station.Station;

import java.util.List;

public interface FuelService {
    List<Fuel> getFuelByName(String fuelName);

    void addFuel(Station station, Fuel fuel);

    void updateFuel(int id, String fuelName, String description, double price, String country);

    void deleteFuel(int id);

    List<Fuel> findAll();
}