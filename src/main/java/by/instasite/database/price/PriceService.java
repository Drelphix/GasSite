package by.instasite.database.price;


import by.instasite.database.fuel.Fuel;

import java.util.List;

public interface PriceService {

    Price getOne(int id);

    void addPrice(Fuel fuel, Price price);

    void deletePrice(int id);

    List<Price> findAll();
}