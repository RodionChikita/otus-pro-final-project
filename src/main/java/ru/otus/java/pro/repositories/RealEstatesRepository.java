package ru.otus.java.pro.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.entities.RealEstate;
import ru.otus.java.pro.entities.RealEstateType;

import java.util.UUID;

@Repository
public interface RealEstatesRepository extends ListCrudRepository<RealEstate, Long> {
    @Query("""
            INSERT INTO real_estates (ad_id, real_estate_type, number_of_rooms, floor, square)
            VALUES (:ad_id, :real_estate_type, :number_of_rooms, :floor, :square);
            """)
    void createNewRealEstate(UUID adId, RealEstateType realEstateType, byte numberOfRooms, byte floor, int square);
}
