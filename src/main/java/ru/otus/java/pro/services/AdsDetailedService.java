package ru.otus.java.pro.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.java.pro.dtos.AdDto;
import ru.otus.java.pro.entities.CategoryEnum;
import ru.otus.java.pro.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdsDetailedService {
    private final AdsService adsService;
    private final RealEstatesService realEstatesService;

    public AdsDetailedService(AdsService adsService, RealEstatesService realEstatesService) {
        this.adsService = adsService;
        this.realEstatesService = realEstatesService;
    }

    public Optional<? extends AdDto> findById(@PathVariable UUID id) {
        Optional<AdDto> adDto = adsService.findById(id);
        CategoryEnum categoryEnum = adDto.get().getCategoryEnum();
        if (categoryEnum == CategoryEnum.REAL_ESTATE){
            return realEstatesService.findById(id);
        }else {
            return Optional.empty();
        }
    }

    public List<Optional<? extends AdDto>> findAll(){
        List<AdDto> adDtoList = adsService.findAll();
        List<Optional<? extends AdDto>> adDetailedDtoList = new ArrayList<>();
        for (AdDto adDto : adDtoList){
            adDetailedDtoList.add(findById(adDto.getId()));
        }
        return adDetailedDtoList;
    }

    public List<Optional<? extends AdDto>> findAllByClientId(@PathVariable Long id){
        List<AdDto> adDtoList = adsService.findAllByClientId(id);
        List<Optional<? extends AdDto>> adDetailedDtoList = new ArrayList<>();
        for (AdDto adDto : adDtoList){
            adDetailedDtoList.add(findById(adDto.getId()));
        }
        return adDetailedDtoList;
    }
}
