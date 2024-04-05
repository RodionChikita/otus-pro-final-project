package ru.otus.java.pro.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@Table("ads")
public class Ad {
    @Id
    private UUID adId;
    @Transient
    private String title;
    @Transient
    private Date postingDate;
    @Transient
    private String description;
    @Transient
    private Long price;
    @Transient
    private boolean actuality;
    @Transient
    private String city;
    @Transient
    private String fullAddress;
    @Transient
    private CategoryEnum categoryEnum;
    @Transient
    private Long clientId;

    @PersistenceCreator
    public Ad(UUID adId, String title, Long clientId, Date postingDate, String description, Long price, boolean actuality, String city, String fullAddress, CategoryEnum categoryEnum) {
        this.adId = adId;
        this.title = title;
        this.postingDate = postingDate;
        this.description = description;
        this.price = price;
        this.actuality = actuality;
        this.city = city;
        this.fullAddress = fullAddress;
        this.categoryEnum = categoryEnum;
        this.clientId = clientId;
    }
}
