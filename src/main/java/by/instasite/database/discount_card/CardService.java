package by.instasite.database.discount_card;


public interface CardService {
    Card getCardById(int id);

    int getDiscountByTelephone(String telephone);

    void addCard(Card card);

    void updateCard(int id, int discount);

    void deleteCard(int id);

}