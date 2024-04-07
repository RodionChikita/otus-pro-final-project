package ru.otus.java.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.java.pro.dtos.AdDto;
import ru.otus.java.pro.entities.Ad;
import ru.otus.java.pro.entities.Client;
import ru.otus.java.pro.repositories.AdsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdsService<T extends Ad> {
    private final AdsRepository adsRepository;

    @Autowired
    public AdsService(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    public void createNewAd(T createOrUpdateAdDtoRq, UUID adId) {
        Ad newAd = Ad.builder()
                .adId(adId)
                .city(createOrUpdateAdDtoRq.getCity())
                .price(createOrUpdateAdDtoRq.getPrice())
                .title(createOrUpdateAdDtoRq.getTitle())
                .actuality(true)
                .categoryEnum(createOrUpdateAdDtoRq.getCategoryEnum())
                .clientId(createOrUpdateAdDtoRq.getClientId())
                .description(createOrUpdateAdDtoRq.getDescription())
                .fullAddress(createOrUpdateAdDtoRq.getFullAddress())
                .postingDate(createOrUpdateAdDtoRq.getPostingDate())
                .build();
        adsRepository.createNewAd(newAd.getAdId(), newAd.getTitle(), newAd.getPostingDate(), newAd.getDescription(), newAd.getPrice(), newAd.isActuality(), newAd.getDescription(), newAd.getFullAddress(), newAd.getCategoryEnum(), newAd.getClientId());
    }

    public Optional<AdDto> findById(@PathVariable UUID id) {
        return adsRepository.findByIdAdDto(id);
    }

    public List<AdDto> findAll() {
        return adsRepository.findAllAdsDto();
    }
}
