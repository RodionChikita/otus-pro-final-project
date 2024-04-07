package ru.otus.java.pro.controllers;

import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.dtos.CreateOrUpdateMessageDtoRq;
import ru.otus.java.pro.services.MessagesService;

@RestController
@RequestMapping("api/v1/chats/messages")
public class MessagesController {
    private final MessagesService messagesService;

    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @PostMapping
    private void createNewMessage(@RequestBody CreateOrUpdateMessageDtoRq createOrUpdateMessageDtoRq) {
        messagesService.createNewMessage(createOrUpdateMessageDtoRq);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        messagesService.deleteById(id);
    }

    @PatchMapping("/{id}/messageText")
    public void updateMessageTextById(@PathVariable Long id, @RequestParam String value) {
        messagesService.updateMessageTextById(id, value);
    }
}
