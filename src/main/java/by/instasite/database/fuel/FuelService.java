package by.instasite.database.fuel;

import by.instasite.database.gas_station.Station;
import by.instasite.database.price.Price;

import java.util.List;

public interface FuelService {
    List<Fuel> getFuelByName(String fuelName);

    void addFuel(Fuel fuel);

    void updateFuel(int id, String fuelName, String description, Price price, Station station);

    void deleteFuel(int id);

    List<Fuel> findAll();
}