package by.instasite.database.price;


import by.instasite.database.fuel.Fuel;

import java.util.List;

public interface PriceService {

    void addPrice(Fuel fuel, Price price);

    void deletePrice(int id);

    List<Price> findAll();
}