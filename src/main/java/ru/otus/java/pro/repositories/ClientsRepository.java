package ru.otus.java.pro.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.entities.Client;

@Repository
public interface ClientsRepository extends ListCrudRepository<Client, Long> {
}
