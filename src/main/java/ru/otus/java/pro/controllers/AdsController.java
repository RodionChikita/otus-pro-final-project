package ru.otus.java.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.java.pro.services.AdsService;

//@RestController
//@RequestMapping("/api/v1/ads")
public class AdsController {
    private final AdsService adsService;

    @Autowired
    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

}
