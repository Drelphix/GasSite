package by.instasite.database.gas_station;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer> {
    Station findByName(String name);

    Station findByAddress(String address);
}