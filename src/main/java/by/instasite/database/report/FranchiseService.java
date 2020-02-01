package by.instasite.database.report;

import java.util.List;

public interface FranchiseService {

    void saveFranchise(Franchise franchise);

    void deleteFranchise(int id);

    List<Franchise> findAll();
}