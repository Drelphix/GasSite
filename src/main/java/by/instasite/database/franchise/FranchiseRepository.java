package by.instasite.database.franchise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
    Franchise findByName(String name);
}