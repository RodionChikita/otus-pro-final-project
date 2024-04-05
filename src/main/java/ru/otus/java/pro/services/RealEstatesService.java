package ru.otus.java.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.java.pro.dtos.CreateOrUpdateRealEstateDtoRq;
import ru.otus.java.pro.entities.RealEstate;
import ru.otus.java.pro.repositories.RealEstatesRepository;

import java.util.Date;
import java.util.UUID;

@Service
public class RealEstatesService {
    private final RealEstatesRepository realEstatesRepository;
    private final AdsService<RealEstate> adsService;

    @Autowired
    public RealEstatesService(RealEstatesRepository realEstatesRepository, AdsService<RealEstate> adsService) {
        this.realEstatesRepository = realEstatesRepository;
        this.adsService = adsService;
    }

    public void createNewRealEstate(CreateOrUpdateRealEstateDtoRq createOrUpdateRealEstateDtoRq
    ) {
        RealEstate newRealEstate = RealEstate.builder()
                .realEstateType(createOrUpdateRealEstateDtoRq.getRealEstateType())
                .numberOfRooms(createOrUpdateRealEstateDtoRq.getNumberOfRooms())
                .floor(createOrUpdateRealEstateDtoRq.getFloor())
                .adId(UUID.randomUUID())
                .title(createOrUpdateRealEstateDtoRq.getTitle())
                .city(createOrUpdateRealEstateDtoRq.getCity())
                .price(createOrUpdateRealEstateDtoRq.getPrice())
                .actuality(true)
                .categoryEnum(createOrUpdateRealEstateDtoRq.getCategoryEnum())
                .clientId(createOrUpdateRealEstateDtoRq.getClientId())
                .description(createOrUpdateRealEstateDtoRq.getDescription())
                .fullAddress(createOrUpdateRealEstateDtoRq.getFullAddress())
                .postingDate(new Date())
                .square(createOrUpdateRealEstateDtoRq.getSquare())
                .build();
        //realEstatesRepository.save(newRealEstate);
        adsService.createNewAd(newRealEstate, newRealEstate.getAdId());
        realEstatesRepository.createNewRealEstate(newRealEstate.getAdId(), newRealEstate.getRealEstateType(), newRealEstate.getNumberOfRooms(), newRealEstate.getFloor(), newRealEstate.getSquare());
    }
}
