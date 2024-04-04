package ru.otus.java.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.java.pro.dtos.CreateOrUpdateRealEstateDtoRq;
import ru.otus.java.pro.services.RealEstatesService;

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
}
