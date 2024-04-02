package ru.otus.java.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.java.pro.dtos.CreateOrUpdateRealEstateDtoRq;
import ru.otus.java.pro.entities.RealEstate;
import ru.otus.java.pro.repositories.RealEstatesRepository;

import java.util.UUID;
@Service
public class RealEstatesService {
    private final RealEstatesRepository realEstatesRepository;
    @Autowired
    public RealEstatesService(RealEstatesRepository realEstatesRepository) {
        this.realEstatesRepository = realEstatesRepository;
    }
    public void createNewRealEstates(CreateOrUpdateRealEstateDtoRq createOrUpdateRealEstateDtoRq, UUID adId) {
        RealEstate newRealEstate = new RealEstate(null, createOrUpdateRealEstateDtoRq.getRealEstateType(), createOrUpdateRealEstateDtoRq.getNumberOfRooms(), createOrUpdateRealEstateDtoRq.getFloor(), createOrUpdateRealEstateDtoRq.getSquare(), adId);
        realEstatesRepository.save(newRealEstate);
    }
}
