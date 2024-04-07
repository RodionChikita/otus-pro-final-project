package ru.otus.java.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.dtos.ClientDto;
import ru.otus.java.pro.dtos.CreateOrUpdateClientDtoRq;
import ru.otus.java.pro.dtos.SimplestPageDto;
import ru.otus.java.pro.entities.Client;
import ru.otus.java.pro.exceptions.ResourceNotFoundException;
import ru.otus.java.pro.services.ClientsService;

import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientsController {
    private final ClientsService clientsService;
    private static final Function<Client, ClientDto> MAP_TO_DTO_FUNCTION = a -> new ClientDto(a.getId(), a.getFullName(), a.getDateOfAccountCreate(), a.getActualAds(), a.getArchivedAds(), a.getFeaturedAds(), a.getReviews(), a.getCustomerChats(), a.getSellerChats());

    @Autowired
    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @PostMapping
    public void createNewClient(@RequestBody CreateOrUpdateClientDtoRq createOrUpdateClientDtoRq) {
        clientsService.createNewClient(createOrUpdateClientDtoRq);
    }

    @GetMapping("/{id}")
    public ClientDto findClientById(@PathVariable Long id) {
        return clientsService.findById(id).map(MAP_TO_DTO_FUNCTION).orElseThrow(() -> new ResourceNotFoundException("Message not found"));
    }

    @GetMapping
    public SimplestPageDto<ClientDto> findAllClients() {
        return new SimplestPageDto<>(clientsService.findAll().stream().map(MAP_TO_DTO_FUNCTION).collect(Collectors.toList()));
    }

    @PatchMapping("/{id}/fullName")
    public void updateFullNameById(@PathVariable Long id, @RequestParam String value) {
        clientsService.updateFullNameById(id, value);
    }
}
