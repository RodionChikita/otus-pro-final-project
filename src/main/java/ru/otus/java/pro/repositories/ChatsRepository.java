package ru.otus.java.pro.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.entities.Chat;
@Repository
public interface ChatsRepository extends ListCrudRepository<Chat, Long> {
}
