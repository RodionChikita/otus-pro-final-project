package ru.otus.java.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.java.pro.dtos.CreateOrUpdateClientDtoRq;
import ru.otus.java.pro.entities.Client;
import ru.otus.java.pro.repositories.ClientsRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {
    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ClientsRepository clientRepository) {
        this.clientsRepository = clientRepository;
    }

    public void createNewClient(CreateOrUpdateClientDtoRq createOrUpdateClientDtoRq) {
        Client newClient = Client.builder()
                .fullName(createOrUpdateClientDtoRq.getFullName())
                .dateOfAccountCreate(new Date())
                .build();
        clientsRepository.save(newClient);
    }

    public Optional<Client> findById(@PathVariable Long id) {
        return clientsRepository.findById(id);
    }

    public List<Client> findAll() {
        return clientsRepository.findAll();
    }
}
