package ru.otus.java.pro.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@Table("ads")
public class Ad<T extends Category> {
    @Id
    private UUID id;
    private String title;
    private Date postingDate;
    private String description;
    private Long price;
    private boolean actuality;
    private String city;
    private String fullAddress;
    private CategoryEnum categoryEnum;
    @MappedCollection(idColumn = "ad_id")
    @Transient
    private T category;
    private Long clientId;
    @PersistenceCreator
    public Ad(UUID id, String title, Long clientId, Date postingDate, String description, Long price, boolean actuality, String city, String fullAddress, CategoryEnum categoryEnum, T category) {
        this.id = id;
        this.title = title;
        this.postingDate = postingDate;
        this.description =description;
        this.price = price;
        this.actuality = actuality;
        this.city = city;
        this.fullAddress = fullAddress;
        this.categoryEnum = categoryEnum;
        this.clientId = clientId;
        this.category = category;
    }
}
