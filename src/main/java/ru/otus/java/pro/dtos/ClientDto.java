package ru.otus.java.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.java.pro.entities.Ad;
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
    private Set<Ad> actualAds;
    private Set<Ad> archivedAds;
    private Set<Ad> featuredAds;
    private Set<Review> reviews;
}
