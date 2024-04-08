package ru.otus.java.pro.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.dtos.RealEstateDto;
import ru.otus.java.pro.entities.RealEstate;
import ru.otus.java.pro.entities.RealEstateType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RealEstatesRepository extends ListCrudRepository<RealEstate, UUID> {
    @Query("""
            select a.id, a.title, a.posting_date, a.description, a.price, a.actuality, a.city, a.full_address, a.category_enum, a.client_id 
            from ADS a
            where a.id = :id
            """)
    Optional<RealEstateDto> findByIdRealEstateDto(UUID id);

    @Query("""
            select a.id, a.title, a.posting_date, a.description, a.price, a.actuality, a.city, a.full_address, a.category_enum, a.client_id, r.real_estate_type, r. number_of_rooms, r.floor, r.square 
            from ADS a
            left join REAL_ESTATES r
            rs on rs.id = id
            """)
    List<RealEstateDto> findAllRealEstatesDto();
}
