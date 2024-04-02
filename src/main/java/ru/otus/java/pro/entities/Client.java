package ru.otus.java.pro.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@Table("clients")
public class Client {
    @Id
    private Long id;
    private String fullName;
    private Date dateOfAccountCreate;
    @MappedCollection(idColumn = "client_id")
    private Set<Ad> actualAds;
    @MappedCollection(idColumn = "client_id")
    private Set<Ad> archivedAds;
    @MappedCollection(idColumn = "client_id")
    private Set<Ad> featuredAds;
    @MappedCollection(idColumn = "client_reviewed_id")
    private Set<Review> reviews;
    @PersistenceCreator
    public Client(Long id, String fullName, Date dateOfAccountCreate, Set<Ad> actualAds, Set<Ad> archivedAds, Set<Ad> featuredAds) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfAccountCreate = dateOfAccountCreate;
        this.actualAds = actualAds;
        this.archivedAds = archivedAds;
        this.featuredAds = featuredAds;
    }
}
