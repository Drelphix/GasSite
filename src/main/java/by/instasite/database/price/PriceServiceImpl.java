package by.instasite.database.price;

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
    public void addPrice(Price price) {
        repository.save(price);
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