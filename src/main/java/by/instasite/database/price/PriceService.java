package by.instasite.database.price;


import java.util.List;

public interface PriceService {
    Price getPriceById(int id);

    void addPrice(Price price);

    void updatePrice(int id, int idStation, int idFuel, double price);

    void deletePrice(int id);

    List<Price> findAll();
}