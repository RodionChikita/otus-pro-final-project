package ru.otus.java.pro.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.entities.Client;

@Repository
public interface ClientsRepository extends ListCrudRepository<Client, Long> {
    @Query("update clients set full_name = :fullName where id = :id")
    @Modifying
    void changeFullNameById(Long id, String fullName);
}
