package by.instasite.database.client;

import java.util.List;

public interface ClientService {
    List<Client> getClientByName(String name);

    Client getClientByTelephone(String telephone);

    Client getClientByCard(int card);

    int getCardById(int id);

    void saveClient(Client client);

    void updateClient(int id, String name, String surname, String address, String telephone, int card);

    void deleteClient(int id);

    List<Client> findAll();
}