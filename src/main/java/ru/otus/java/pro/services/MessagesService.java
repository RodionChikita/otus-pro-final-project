package ru.otus.java.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.java.pro.dtos.CreateOrUpdateChatDtoRq;
import ru.otus.java.pro.dtos.CreateOrUpdateMessageDtoRq;
import ru.otus.java.pro.entities.Chat;
import ru.otus.java.pro.entities.Message;
import ru.otus.java.pro.repositories.MessagesRepository;

import java.util.Date;
@Service
public class MessagesService {
    private final MessagesRepository messagesRepository;
    @Autowired
    public MessagesService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }
    public void createNewMessage(CreateOrUpdateMessageDtoRq createOrUpdateMessageDtoRq) {
        Message newMessage = new Message(null, createOrUpdateMessageDtoRq.getMessageText(), createOrUpdateMessageDtoRq.getClientId(), new Date());
        messagesRepository.save(newMessage);
    }
}
