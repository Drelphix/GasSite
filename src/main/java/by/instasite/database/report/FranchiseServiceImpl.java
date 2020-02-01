package by.instasite.database.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private FranchiseRepository repository;

    @Autowired
    public void setFranchiseRepository(FranchiseRepository repository) {
        this.repository = repository;
    }


    @Override
    public void saveFranchise(Franchise franchise) {
        repository.save(franchise);
    }


    @Override
    public void deleteFranchise(int id) {
        Franchise deleted = repository.getOne(id);
        repository.delete(deleted);
    }

    @Override
    public List<Franchise> findAll() {
        return repository.findAll();
    }
}