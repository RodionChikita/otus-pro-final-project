package ru.otus.java.pro.controllers;

import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.dtos.ChatDto;
import ru.otus.java.pro.dtos.ClientDto;
import ru.otus.java.pro.dtos.CreateOrUpdateChatDtoRq;
import ru.otus.java.pro.entities.Chat;
import ru.otus.java.pro.exceptions.ResourceNotFoundException;
import ru.otus.java.pro.services.ChatsService;

import java.util.function.Function;

@RestController
@RequestMapping("api/v1/chats")
public class ChatController {
    private final ChatsService chatsService;
    private static final Function<Chat, ChatDto> MAP_TO_DTO_FUNCTION = a -> new ChatDto(a.getId(), a.getClientCustomerId(), a.getClientSellerId(), a.getAdId(), a.getCreatedAt());
    public ChatController(ChatsService chatsService) {
        this.chatsService = chatsService;
    }
    @PostMapping
    public void createNewChat(@RequestBody CreateOrUpdateChatDtoRq createOrUpdateChatDtoRq) {
        chatsService.createNewChat(createOrUpdateChatDtoRq);
    }
    @GetMapping("/{id}")
    public ChatDto findChatById(@PathVariable Long id){
        return chatsService.findById(id).map(MAP_TO_DTO_FUNCTION).orElseThrow(() -> new ResourceNotFoundException("Chat not found"));
    }
}
