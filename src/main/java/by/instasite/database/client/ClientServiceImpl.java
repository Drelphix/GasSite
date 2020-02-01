package by.instasite.database.client;

import by.instasite.database.discount_card.Card;
import by.instasite.database.discount_card.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;
    private CardRepository cardRepository;

    @Override
    public List<Client> getClientByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Client getClientByTelephone(String telephone) {
        return repository.findByTelephone(telephone);
    }

    @Override
    public Client getClientByCard(int card) {
        return repository.findByCard(card);
    }


    @Override
    public Card getCardById(int id) {
        return repository.getOne(id).getCard();
    }

    @Override
    public void saveClient(Client client) {
        repository.save(client);
    }

    @Override
    public void updateClient(int id, String name, String surname, String address, String telephone, int card) {
        Client updated = repository.getOne(id);
        Card cardUpdate = cardRepository.getOne(card);
        updated.setSurname(surname);
        updated.setAddress(address);
        updated.setTelephone(telephone);
        updated.setCard(cardUpdate);
        repository.save(updated);
    }

    @Override
    public void deleteClient(int id) {
        Client delete = repository.getOne(id);
        repository.delete(delete);
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = repository.findAll();
        return clients;
    }
}
