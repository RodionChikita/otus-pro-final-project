package ru.otus.java.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.dtos.*;
import ru.otus.java.pro.entities.Client;
import ru.otus.java.pro.exceptions.ResourceNotFoundException;
import ru.otus.java.pro.services.AdsDetailedService;
import ru.otus.java.pro.services.ClientsService;
import ru.otus.java.pro.services.ReviewsService;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientsController {
    private final ClientsService clientsService;
    private final AdsDetailedService adsDetailedService;
    private final ReviewsService reviewsService;
    private static final Function<Client, ClientDto> MAP_TO_DTO_FUNCTION = a -> new ClientDto(a.getId(), a.getFullName(), a.getDateOfAccountCreate(), a.getReviews(), a.getSellerChats(), a.getCustomerChats());

    @Autowired
    public ClientsController(ClientsService clientsService, AdsDetailedService adsDetailedService, ReviewsService reviewsService) {
        this.clientsService = clientsService;
        this.adsDetailedService = adsDetailedService;
        this.reviewsService = reviewsService;
    }

    @PostMapping
    public void createNewClient(@RequestBody CreateOrUpdateClientDtoRq createOrUpdateClientDtoRq) {
        clientsService.createNewClient(createOrUpdateClientDtoRq);
    }

    @GetMapping("/{id}")
    public ClientDto findClientById(@PathVariable Long id) {
        return clientsService.findById(id).map(MAP_TO_DTO_FUNCTION).orElseThrow(() -> new ResourceNotFoundException("Chat not found"));
    }

    @GetMapping
    public SimplestPageDto<ClientDto> findAllClients() {
        return new SimplestPageDto<>(clientsService.findAll().stream().map(MAP_TO_DTO_FUNCTION).collect(Collectors.toList()));
    }

    @PatchMapping("/{id}/fullName")
    public void updateFullNameById(@PathVariable Long id, @RequestParam String value) {
        clientsService.updateFullNameById(id, value);
    }

    @GetMapping("/{id}/ads")
    public List<Optional<? extends AdDto>> findAllAdsByClientId(@PathVariable Long id) {
        return adsDetailedService.findAllByClientId(id);
    }

    @GetMapping("/{id}/reviews")
    public List<ReviewDto> findAllReviewsByClientId(@PathVariable Long id) {
        return reviewsService.findAllByClientId(id);
    }

    @GetMapping("/{id}/actualAds")
    public List<Optional<? extends AdDto>> findAllActualAdsByClientId(@PathVariable Long id) {
        return adsDetailedService.findAllByClientIdAndActuality(id, true);
    }

    @GetMapping("/{id}/archivedAds")
    public List<Optional<? extends AdDto>> findAllArchivedAdsByClientId(@PathVariable Long id) {
        return adsDetailedService.findAllByClientIdAndActuality(id, false);
    }

    @GetMapping("/{id}/featuredAds")
    public List<Optional<? extends AdDto>> findAllFeaturedAdsByClientId(@PathVariable Long id) {
        return adsDetailedService.findAllByClientIdAndFeature(id);
    }
}
