package by.instasite.database.fuel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {
    List<Fuel> findByFuelName(String fuelName);

}