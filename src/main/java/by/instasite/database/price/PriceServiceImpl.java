package by.instasite.database.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private PriceRepository repository;

    @Override
    public Price getPriceById(int id) {
        return null;
    }

    @Override
    public void addPrice(Price price) {
        repository.save(price);
    }

    @Override
    public void updatePrice(int id, int idStation, int idFuel, double price) {
        Price updated = repository.getOne(id);
        updated.setIdStation(idStation);
        updated.setIdFuel(idFuel);
        updated.setPrice(price);
        repository.save(updated);
    }

    @Override
    public void deletePrice(int id) {
        Price deleted = repository.getOne(id);
        repository.delete(deleted);
    }

    @Override
    public List<Price> findAll() {
        return repository.findAll();
    }
}