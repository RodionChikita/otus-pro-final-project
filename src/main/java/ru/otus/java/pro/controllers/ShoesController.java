package ru.otus.java.pro.controllers;

import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.dtos.*;
import ru.otus.java.pro.exceptions.ResourceNotFoundException;
import ru.otus.java.pro.services.ShoesService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ads/shoes")
public class ShoesController {
    private final ShoesService shoesService;

    public ShoesController(ShoesService shoesService) {
        this.shoesService = shoesService;
    }

    @PostMapping
    public void createNewAd(@RequestBody CreateOrUpdateShoesDtoRq createOrUpdateShoesDtoRq) {
        shoesService.createNewShoes(createOrUpdateShoesDtoRq);
    }
    @GetMapping("/{id}")
    public AdDto findAdById(@PathVariable UUID id) {
        return shoesService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ad not found"));
    }

    @GetMapping
    public SimplestPageDto<ShoesDto> findAllAds() {
        return new SimplestPageDto<>(shoesService.findAll());
    }
}
