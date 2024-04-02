package ru.otus.java.pro.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.entities.Review;

@Repository
public interface ReviewsRepository extends ListCrudRepository<Review, Long> {
}
