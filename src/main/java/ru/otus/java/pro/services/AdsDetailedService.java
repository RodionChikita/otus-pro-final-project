package ru.otus.java.pro.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.java.pro.dtos.AdDto;
import ru.otus.java.pro.entities.CategoryEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdsDetailedService {
    private final AdsService adsService;
    private final RealEstatesService realEstatesService;
    private final ShoesService shoesService;

    public AdsDetailedService(AdsService adsService, RealEstatesService realEstatesService, ShoesService shoesService) {
        this.adsService = adsService;
        this.realEstatesService = realEstatesService;
        this.shoesService = shoesService;
    }

    public Optional<? extends AdDto> findById(@PathVariable UUID id) {
        Optional<AdDto> adDto = adsService.findById(id);
        CategoryEnum categoryEnum = adDto.get().getCategoryEnum();
        switch (categoryEnum) {
            case REAL_ESTATE -> {
                return realEstatesService.findById(id);
            }
            case SHOES -> {
                return shoesService.findById(id);
            }
            default -> {
                return Optional.empty();
            }
        }
    }

    public List<Optional<? extends AdDto>> findAll() {
        List<AdDto> adDtoList = adsService.findAll();
        List<Optional<? extends AdDto>> adDetailedDtoList = new ArrayList<>();
        for (AdDto adDto : adDtoList) {
            adDetailedDtoList.add(findById(adDto.getId()));
        }
        return adDetailedDtoList;
    }

    public List<Optional<? extends AdDto>> findAllByClientId(@PathVariable Long id) {
        List<AdDto> adDtoList = adsService.findAllByClientId(id);
        List<Optional<? extends AdDto>> adDetailedDtoList = new ArrayList<>();
        for (AdDto adDto : adDtoList) {
            adDetailedDtoList.add(findById(adDto.getId()));
        }
        return adDetailedDtoList;
    }

    public List<Optional<? extends AdDto>> findAllByClientIdAndActuality(@PathVariable Long id, boolean isActual) {
        List<AdDto> adDtoList = adsService.findAllByClientIdAndActuality(id, isActual);
        List<Optional<? extends AdDto>> adDetailedDtoList = new ArrayList<>();
        for (AdDto adDto : adDtoList) {
            adDetailedDtoList.add(findById(adDto.getId()));
        }
        return adDetailedDtoList;
    }
}
