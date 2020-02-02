package by.instasite.database.franchise;

import java.util.List;

public interface FranchiseService {

    void saveFranchise(Franchise franchise);

    void updateFranchise(Franchise franchise, String name);

    void deleteFranchise(int id);

    List<Franchise> findAll();
}