package ru.otus.java.pro.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.entities.Ad;
import ru.otus.java.pro.entities.CategoryEnum;

import java.util.Date;
import java.util.UUID;

@Repository
public interface AdsRepository extends ListCrudRepository<Ad, UUID> {
    @Query("""
            INSERT INTO ads (ad_id, title, posting_date, description, price, actuality, city, full_address, category_enum, client_id)
            VALUES (:adId, :title, :postingDate, :description, :price, :actuality, :city, :fullAddress, :categoryEnum, :clientId);
            """)
    void createNewAd(UUID adId, String title, Date postingDate, String description, Long price, boolean actuality, String city, String fullAddress, CategoryEnum categoryEnum, Long clientId);
}
