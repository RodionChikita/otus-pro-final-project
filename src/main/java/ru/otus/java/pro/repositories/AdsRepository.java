package ru.otus.java.pro.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.dtos.AdDto;
import ru.otus.java.pro.entities.Ad;
import ru.otus.java.pro.entities.CategoryEnum;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdsRepository extends ListCrudRepository<Ad, UUID> {
    @Modifying
    @Query("""
            INSERT INTO ads (id, title, posting_date, description, price, actuality, city, full_address, category_enum, client_id)
            VALUES (:id, :title, :postingDate, :description, :price, :actuality, :city, :fullAddress, :categoryEnum, :clientId);
            """)
    void createNewAd(UUID id, String title, Date postingDate, String description, Long price, boolean actuality, String city, String fullAddress, CategoryEnum categoryEnum, Long clientId);

    @Query("""
            select a.id, a.title, a.posting_date, a.description, a.price, a.actuality, a.city, a.full_address, a.category_enum, a.client_id 
            from ADS a
            where a.id = :id;
            """)
    Optional<AdDto> findByIdAdDto(UUID id);

    @Query("""
            select a.id, a.title, a.posting_date, a.description, a.price, a.actuality, a.city, a.full_address, a.category_enum, a.client_id 
            from ADS a
            """)
    List<AdDto> findAllAdsDto();
}
