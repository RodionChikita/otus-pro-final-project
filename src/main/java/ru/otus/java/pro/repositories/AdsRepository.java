package ru.otus.java.pro.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.dtos.CreateOrUpdateAdDtoRq;
import ru.otus.java.pro.entities.Ad;
import ru.otus.java.pro.entities.Category;
import ru.otus.java.pro.entities.CategoryEnum;

import java.util.Date;

@Repository
public interface AdsRepository<T extends Category> extends ListCrudRepository<Ad<T>, Long> {
    @Query(
            """
                    INSERT INTO ads (title, description, price, city, fullAddress, categoryEnum, clientId)\s
                    VALUES (?, ?, ?, ?, ?, ?, ?);
                                        
                    INSERT INTO categoryEnumS (*)
                    VALUES (*);
                    """
    )
    public void addNewAd(
            Long id,
            String title,
            Date postingDate,
            String description,
            Long price,
            boolean actuality,
            String city,
            String fullAddress,
            String categoryEnum,
            Long clientId);
}
