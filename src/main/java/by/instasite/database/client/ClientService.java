package by.instasite.database.client;

import by.instasite.database.discount_card.Card;

import java.util.List;

public interface ClientService {
    List<Client> getClientByName(String name);

    Client getClientByTelephone(String telephone);

    Client getClientById(int id);

    Client getClientByCard(int card);

    Card getCardById(int id);

    void saveClient(Client client);

    void updateClient(int id, String name, String surname, String address, String telephone, Card card);

    void deleteClient(int id);

    List<Client> findAll();
}