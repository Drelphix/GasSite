package by.instasite.database.gas_station;

import by.instasite.database.franchise.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    private StationRepository repository;


    @Autowired
    public void setStationRepository(StationRepository repository) {
        this.repository = repository;
    }


    @Override
    public Station getStationByAddress(String address) {
        return repository.findByAddress(address);
    }

    @Override
    public Station getStationByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Station getStationById(int id) {
        return repository.getOne(id);
    }

    @Override
    public void saveStation(Station station) {
        repository.saveAndFlush(station);
    }

    @Override
    public void updateStation(int id, String name, String address, Franchise franchise) {
        Station updated = repository.getOne(id);
        updated.setAddress(address);
        updated.setName(name);
        updated.setFranchise(franchise);
        repository.save(updated);
    }

    @Override
    public void deleteStation(int id) {
        Station deleted = repository.getOne(id);
        repository.delete(deleted);
    }

    @Override
    public List<Station> findAll() {
        return repository.findAll();
    }
}