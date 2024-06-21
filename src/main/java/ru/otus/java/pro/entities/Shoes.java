package ru.otus.java.pro.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Table("shoes")
@SuperBuilder
public class Shoes extends Ad {
    private byte size;
    private String brand;

    public Shoes(UUID id, UUID adId, String title, Long clientId, Date postingDate, String description, Long price, boolean actuality, String city, String fullAddress, CategoryEnum categoryEnum, byte size, String brand) {
        super(id, adId, title, clientId, postingDate, description, price, actuality, city, fullAddress, categoryEnum);
        this.size = size;
        this.brand = brand;
    }
}
