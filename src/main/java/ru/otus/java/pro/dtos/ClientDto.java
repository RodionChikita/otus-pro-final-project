package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.MappedCollection;
import ru.otus.java.pro.entities.Ad;
import ru.otus.java.pro.entities.Chat;
import ru.otus.java.pro.entities.RealEstate;
import ru.otus.java.pro.entities.Review;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Long id;
    private String fullName;
    private Date dateOfAccountCreate;
    private Set<RealEstate> actualAds;
    private Set<RealEstate> archivedAds;
    private Set<RealEstate> featuredAds;
    private Set<Review> reviews;
    private Set<Chat> customerChats;
    private Set<Chat> sellerChats;
}
