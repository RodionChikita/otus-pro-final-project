package ru.otus.java.pro.repositories;

import org.springframework.data.repository.ListCrudRepository;
import ru.otus.java.pro.entities.RealEstate;

public interface RealEstatesRepository extends ListCrudRepository<RealEstate, Long> {
}
