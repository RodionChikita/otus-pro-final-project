package ru.otus.java.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.java.pro.dtos.CreateOrUpdateAdDtoRq;
import ru.otus.java.pro.dtos.CreateOrUpdateRealEstateDtoRq;
import ru.otus.java.pro.entities.Category;
import ru.otus.java.pro.services.AdsService;

@RestController
@RequestMapping("/api/v1/ads")
public class AdsController<T extends Category> {
    private final AdsService<T> adsService;
    @Autowired
    public AdsController(AdsService<T> adsService) {
        this.adsService = adsService;
    }
    @PostMapping
    public void createNewAd(@RequestBody CreateOrUpdateAdDtoRq<T> createOrUpdateAdDtoRq) {
        adsService.createNewAd(createOrUpdateAdDtoRq);
    }
}
