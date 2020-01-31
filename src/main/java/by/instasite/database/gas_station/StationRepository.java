package by.instasite.database.gas_station;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, Integer> {
    List<Station> findByName(String name);

    Station findByAddress(String address);
}