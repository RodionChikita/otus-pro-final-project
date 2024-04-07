package ru.otus.java.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.java.pro.dtos.AdDto;
import ru.otus.java.pro.dtos.ClientDto;
import ru.otus.java.pro.dtos.SimplestPageDto;
import ru.otus.java.pro.entities.Ad;
import ru.otus.java.pro.entities.Client;
import ru.otus.java.pro.exceptions.ResourceNotFoundException;
import ru.otus.java.pro.services.AdsService;

import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ads")
public class AdsController {
    private final AdsService<Ad> adsService;

    @Autowired
    public AdsController(AdsService<Ad> adsService) {
        this.adsService = adsService;
    }

    @GetMapping("/{id}")
    public AdDto findAdById(@PathVariable UUID id) {
        return adsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ad not found"));
    }

    @GetMapping
    public SimplestPageDto<AdDto> findAllAds() {
        return new SimplestPageDto<>(adsService.findAll());
    }
}
