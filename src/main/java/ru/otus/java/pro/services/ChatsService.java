package ru.otus.java.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.java.pro.dtos.CreateOrUpdateChatDtoRq;
import ru.otus.java.pro.entities.Chat;
import ru.otus.java.pro.entities.Client;
import ru.otus.java.pro.repositories.ChatsRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class ChatsService {
    private final ChatsRepository chatsRepository;
    @Autowired
    public ChatsService(ChatsRepository chatsRepository) {
        this.chatsRepository = chatsRepository;
    }
    public void createNewChat(CreateOrUpdateChatDtoRq createOrUpdateChatDtoRq){
        Chat newChat = new Chat(null, createOrUpdateChatDtoRq.getClientCustomerId(), createOrUpdateChatDtoRq.getClientSellerId(), createOrUpdateChatDtoRq.getAdId(), new Date(), null);
        chatsRepository.save(newChat);
    }
    public Optional<Chat> findById(@PathVariable Long id) {
        return chatsRepository.findById(id);
    }
}
