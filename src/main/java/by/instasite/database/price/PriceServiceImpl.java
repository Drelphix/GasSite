package by.instasite.database.price;

import by.instasite.database.fuel.Fuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private PriceRepository repository;

    @Autowired
    public void setPriceRepository(PriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addPrice(Fuel fuel, Price price) {
        price.setId(fuel.getId());
        repository.saveAndFlush(price);
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