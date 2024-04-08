package ru.otus.java.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.dtos.AdDto;
import ru.otus.java.pro.dtos.SimplestPageDto;
import ru.otus.java.pro.exceptions.ResourceNotFoundException;
import ru.otus.java.pro.services.AdsDetailedService;
import ru.otus.java.pro.services.AdsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ads")
public class AdsController {
    private final AdsService adsService;
    private final AdsDetailedService adsDetailedService;

    @Autowired
    public AdsController(AdsService adsService, AdsDetailedService adsDetailedService) {
        this.adsService = adsService;
        this.adsDetailedService = adsDetailedService;
    }

    @GetMapping("/{id}")
    public AdDto findAdById(@PathVariable UUID id) {
        return adsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ad not found"));
    }

    @GetMapping
    public SimplestPageDto<AdDto> findAllAds() {
        return new SimplestPageDto<>(adsService.findAll());
    }

    @PatchMapping("/{id}/changeActuality")
    public void updateActualityById(@PathVariable UUID id) {
        adsService.updateActualityById(id);
    }

    @GetMapping("/{id}/detailed")
    public Optional<? extends AdDto> findDetailedAdsById(@PathVariable UUID id) {
        return adsDetailedService.findById(id);
    }

    @GetMapping("/detailed")
    public List<Optional<? extends AdDto>> findAllDetailedAds() {
        return adsDetailedService.findAll();
    }
}
