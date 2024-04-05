package ru.otus.java.pro.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.java.pro.dtos.CreateOrUpdateMessageDtoRq;
import ru.otus.java.pro.services.MessagesService;

@RestController
@RequestMapping("api/v1/chats/messages")
public class MessageController {
    private final MessagesService messagesService;

    public MessageController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @PostMapping
    private void createNewMessage(@RequestBody CreateOrUpdateMessageDtoRq createOrUpdateMessageDtoRq) {
        messagesService.createNewMessage(createOrUpdateMessageDtoRq);
    }
}
