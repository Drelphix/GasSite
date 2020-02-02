package by.instasite.database.discount_card;

import by.instasite.database.client.Client;
import by.instasite.database.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository repository;
    private ClientService clientService;


    @Autowired
    public void setCardRepository(CardRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setClientService(ClientService service) {
        this.clientService = service;
    }

    @Override
    public Card getCardById(int id) {
        return repository.getOne(id);
    }


    @Override
    public int getDiscountByTelephone(String telephone) {
        Client client = clientService.getClientByTelephone(telephone);
        return repository.getOne(client.getId()).getDiscount();
    }

    @Override
    public void addCard(Card card) {
        repository.save(card);
    }

    @Override
    public void updateCard(int id, int discount) {
        Card updated = repository.getOne(id);
        updated.setDiscount(discount);
        repository.save(updated);

    }

    @Override
    public void deleteCard(int id) {
        Card delete = repository.getOne(id);
        repository.delete(delete);
    }

    @Override
    public List<Card> findAll() {
        return repository.findAll();
    }
}