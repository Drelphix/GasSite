package by.instasite.database.fuel;

import by.instasite.database.gas_station.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelServiceImpl implements FuelService {

    private FuelRepository repository;

    @Autowired
    public void setFuelRepository(FuelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Fuel> getFuelByName(String fuelName) {
        List<Fuel> fuels = repository.findByFuelName(fuelName);
        return fuels;
    }

    @Override
    public void addFuel(Station station, Fuel fuel) {
        fuel.setId(station.getId());
        repository.save(fuel);
    }

    @Override
    public void updateFuel(int id, String fuelName, String description, double price, String country) {
        Fuel updated = repository.getOne(id);
        updated.setFuelName(fuelName);
        updated.setDescription(description);
        repository.save(updated);
    }

    @Override
    public void deleteFuel(int id) {
        Fuel delete = repository.getOne(id);
        repository.delete(delete);
    }

    @Override
    public List<Fuel> findAll() {
        return repository.findAll();
    }
}