package ru.otus.java.pro.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@Table("clients")
public class Client {
    @Id
    private Long id;
    private String fullName;
    private Date dateOfAccountCreate;
//    @MappedCollection(idColumn = "client_id")
//    private Set<RealEstate> actualAds;
//    @MappedCollection(idColumn = "client_id")
//    private Set<RealEstate> archivedAds;
//    @MappedCollection(idColumn = "client_id")
//    private Set<RealEstate> featuredAds;
    @MappedCollection(idColumn = "client_reviewed_id")
    private Set<Review> reviews;
    @MappedCollection(idColumn = "client_customer_id")
    private Set<Chat> customerChats;
    @MappedCollection(idColumn = "client_seller_id")
    private Set<Chat> sellerChats;

    @PersistenceCreator
    public Client(Long id, String fullName, Date dateOfAccountCreate, Set<Review> reviews, Set<Chat> customerChats, Set<Chat> sellerChats) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfAccountCreate = dateOfAccountCreate;
        this.reviews = reviews;
        this.customerChats = customerChats;
        this.sellerChats = sellerChats;
    }
}
