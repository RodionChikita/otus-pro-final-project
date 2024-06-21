package ru.otus.java.pro.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Table("real_estates")
@SuperBuilder
public class RealEstate extends Ad {
    private RealEstateType realEstateType;
    private byte numberOfRooms;
    private byte floor;
    private int square;

    @PersistenceCreator
    public RealEstate(RealEstateType realEstateType, byte numberOfRooms, byte floor, int square, UUID id, UUID adId, String title, Long clientId, Date postingDate, String description, Long price, boolean actuality, String city, String fullAddress, CategoryEnum categoryEnum) {
        super(id, adId, title, clientId, postingDate, description, price, actuality, city, fullAddress, categoryEnum);
        this.realEstateType = realEstateType;
        this.numberOfRooms = numberOfRooms;
        this.floor = floor;
        this.square = square;
    }
}
