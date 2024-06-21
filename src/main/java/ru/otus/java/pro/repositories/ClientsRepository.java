package ru.otus.java.pro.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.dtos.ClientDto;
import ru.otus.java.pro.entities.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientsRepository extends ListCrudRepository<Client, Long> {
    @Query("update clients set full_name = :fullName where id = :id")
    @Modifying
    void changeFullNameById(Long id, String fullName);

    @Query("""
            select c.id, c.full_name, c.date_of_account_create
            from CLIENTS c
            """)
    List<ClientDto> findAllClientDto();

    @Query("""
            select c.id, c.full_name, c.date_of_account_create
            from CLIENTS c
            where c.id = :id;
            """)
    Optional<ClientDto> findByIdClientDto(Long id);
}
