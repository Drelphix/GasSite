package by.instasite.database.price;


import java.util.List;

public interface PriceService {

    void addPrice(Price price);


    void deletePrice(int id);

    List<Price> findAll();
}