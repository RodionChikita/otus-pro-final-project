package ru.otus.java.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.java.pro.dtos.CreateOrUpdateRealEstateDtoRq;
import ru.otus.java.pro.dtos.RealEstateDto;
import ru.otus.java.pro.entities.RealEstate;
import ru.otus.java.pro.repositories.RealEstatesRepository;
import com.github.f4b6a3.uuid.UuidCreator;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RealEstatesService {
    private final RealEstatesRepository realEstatesRepository;
    private final AdsService adsService;

    @Autowired
    public RealEstatesService(RealEstatesRepository realEstatesRepository, AdsService adsService) {
        this.realEstatesRepository = realEstatesRepository;
        this.adsService = adsService;
    }

    public void createNewRealEstate(CreateOrUpdateRealEstateDtoRq createOrUpdateRealEstateDtoRq
    ) {
        RealEstate newRealEstate = RealEstate.builder()
                .realEstateType(createOrUpdateRealEstateDtoRq.getRealEstateType())
                .numberOfRooms(createOrUpdateRealEstateDtoRq.getNumberOfRooms())
                .floor(createOrUpdateRealEstateDtoRq.getFloor())
                .adId(UuidCreator.getTimeBased())
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
        adsService.createNewAd(newRealEstate, newRealEstate.getAdId());
        realEstatesRepository.save(newRealEstate);
    }

    public Optional<RealEstateDto> findById(@PathVariable UUID id) {
        return realEstatesRepository.findByIdRealEstateDto(id);
    }

    public List<RealEstateDto> findAll() {
        return realEstatesRepository.findAllRealEstatesDto();
    }
}
