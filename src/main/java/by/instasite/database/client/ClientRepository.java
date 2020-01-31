package by.instasite.database.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByName(String name);

    Client findByTelephone(String telephone);

    Client findByCard(int card);
}