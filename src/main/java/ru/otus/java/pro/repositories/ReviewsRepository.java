package ru.otus.java.pro.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.dtos.ReviewDto;
import ru.otus.java.pro.entities.Review;

import java.util.List;

@Repository
public interface ReviewsRepository extends ListCrudRepository<Review, Long> {
    @Query("""
            select r.id, r.client_id, r.review_text, r.grade, r.created_at, r.client_reviewed_id
            from REVIEWS r
            where r.client_reviewed_id = :id
            """)
    List<ReviewDto> findAllByClientId(Long id);
}
