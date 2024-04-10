package ru.otus.java.pro.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.dtos.RealEstateDto;
import ru.otus.java.pro.dtos.ShoesDto;
import ru.otus.java.pro.entities.Shoes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShoesRepository extends ListCrudRepository<Shoes, Long> {
    @Query("""
            select a.id, a.title, a.posting_date, a.description, a.price, a.actuality, a.city, a.full_address, a.category_enum, a.client_id, s.size, s.brand
            from ADS a
            left join Shoes s on s.id = a.id
            where a.category_enum = 'SHOES'
            """)
    List<ShoesDto> findAllShoesDto();
    @Query("""
            select a.id, a.title, a.posting_date, a.description, a.price, a.actuality, a.city, a.full_address, a.category_enum, a.client_id, s.size, s.brand
            from ADS a
            left join Shoes s on s.id = a.id
            where a.id = :id and a.category_enum = 'SHOES'
            """)
    Optional<ShoesDto> findByIdShoesDto(UUID id);
}
