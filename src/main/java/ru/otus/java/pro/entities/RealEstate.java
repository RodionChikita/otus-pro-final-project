package ru.otus.java.pro.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;
@Getter
@Setter
@Table("real_estates")
public class RealEstate extends Category {
    @Id
    private Long id;
    private RealEstateType realEstateType;
    private byte numberOfRooms;
    private byte floor;
    private int square;
    private UUID adId;
    @PersistenceCreator
    public RealEstate(Long id, RealEstateType realEstateType, byte numberOfRooms, byte floor, int square, UUID adId) {
        this.id = id;
        this.realEstateType = realEstateType;
        this.numberOfRooms = numberOfRooms;
        this.floor = floor;
        this.square = square;
        this.adId = adId;
    }
}
