package ru.otus.java.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.java.pro.dtos.CreateOrUpdateAdDtoRq;
import ru.otus.java.pro.dtos.CreateOrUpdateRealEstateDtoRq;
import ru.otus.java.pro.entities.Ad;
import ru.otus.java.pro.entities.Category;
import ru.otus.java.pro.entities.CategoryEnum;
import ru.otus.java.pro.repositories.AdsRepository;

import java.util.Date;
import java.util.UUID;

@Service
public class AdsService<T extends Category> {
    private final AdsRepository<T> adsRepository;
    private final RealEstatesService realEstatesService;
    @Autowired
    public AdsService(AdsRepository<T> adsRepository, RealEstatesService realEstatesService) {
        this.adsRepository = adsRepository;
        this.realEstatesService = realEstatesService;
    }
    public void createNewAd(CreateOrUpdateAdDtoRq<T> createOrUpdateAdDtoRq) {
        Ad<T> newAd = new Ad<>(UUID.randomUUID(), createOrUpdateAdDtoRq.getTitle(), createOrUpdateAdDtoRq.getClientId(), new Date(), createOrUpdateAdDtoRq.getDescription(), createOrUpdateAdDtoRq.getPrice(), true, createOrUpdateAdDtoRq.getCity(), createOrUpdateAdDtoRq.getFullAddress(), createOrUpdateAdDtoRq.getCategoryEnum(), createOrUpdateAdDtoRq.getCategory());
        if(createOrUpdateAdDtoRq.getCategoryEnum() == CategoryEnum.REAL_ESTATE){
            realEstatesService.createNewRealEstates((CreateOrUpdateRealEstateDtoRq) newAd.getCategory(), newAd.getId());
        }
        adsRepository.save(newAd);
    }
}
