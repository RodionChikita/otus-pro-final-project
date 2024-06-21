package ru.otus.java.pro.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.entities.Message;

@Repository
public interface MessagesRepository extends ListCrudRepository<Message, Long> {
    @Query("update messages set message_text = :messageText where id = :id")
    @Modifying
    void changeMessageTextById(Long id, String messageText);
}
