package ru.otus.java.pro.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.java.pro.dtos.CreateOrUpdateShoesDtoRq;
import ru.otus.java.pro.dtos.ShoesDto;
import ru.otus.java.pro.entities.Shoes;
import ru.otus.java.pro.repositories.ShoesRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShoesService {
    private final ShoesRepository shoesRepository;
    private final AdsService adsService;

    public ShoesService(ShoesRepository shoesRepository, AdsService adsService) {
        this.shoesRepository = shoesRepository;
        this.adsService = adsService;
    }

    public void createNewShoes(CreateOrUpdateShoesDtoRq createOrUpdateShoesDtoRq
    ) {
        Shoes newShoes = Shoes.builder()
                .adId(UUID.randomUUID())
                .title(createOrUpdateShoesDtoRq.getTitle())
                .city(createOrUpdateShoesDtoRq.getCity())
                .price(createOrUpdateShoesDtoRq.getPrice())
                .actuality(true)
                .categoryEnum(createOrUpdateShoesDtoRq.getCategoryEnum())
                .clientId(createOrUpdateShoesDtoRq.getClientId())
                .description(createOrUpdateShoesDtoRq.getDescription())
                .fullAddress(createOrUpdateShoesDtoRq.getFullAddress())
                .postingDate(new Date())
                .size(createOrUpdateShoesDtoRq.getSize())
                .brand(createOrUpdateShoesDtoRq.getBrand())
                .fullAddress(createOrUpdateShoesDtoRq.getFullAddress())
                .build();

        adsService.createNewAd(newShoes, newShoes.getAdId());
        shoesRepository.save(newShoes);
    }

    public Optional<ShoesDto> findById(@PathVariable UUID id) {
        return shoesRepository.findByIdShoesDto(id);
    }

    public List<ShoesDto> findAll() {
        return shoesRepository.findAllShoesDto();
    }
}
