package ru.otus.java.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.dtos.AdDto;
import ru.otus.java.pro.dtos.CreateOrUpdateRealEstateDtoRq;
import ru.otus.java.pro.dtos.RealEstateDto;
import ru.otus.java.pro.dtos.SimplestPageDto;
import ru.otus.java.pro.exceptions.ResourceNotFoundException;
import ru.otus.java.pro.services.RealEstatesService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ads/realEstate")
public class RealEstatesController {
    private final RealEstatesService realEstatesService;

    @Autowired
    public RealEstatesController(RealEstatesService realEstatesService) {
        this.realEstatesService = realEstatesService;
    }

    @PostMapping
    public void createNewAd(@RequestBody CreateOrUpdateRealEstateDtoRq createOrUpdateRealEstateDtoRq) {
        realEstatesService.createNewRealEstate(createOrUpdateRealEstateDtoRq);
    }
    @GetMapping("/{id}")
    public AdDto findAdById(@PathVariable UUID id) {
        return realEstatesService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ad not found"));
    }

    @GetMapping
    public SimplestPageDto<RealEstateDto> findAllAds() {
        return new SimplestPageDto<>(realEstatesService.findAll());
    }
}
