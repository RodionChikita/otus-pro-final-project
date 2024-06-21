package ru.otus.java.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.java.pro.dtos.CreateOrUpdateReviewDtoRq;
import ru.otus.java.pro.dtos.ReviewDto;
import ru.otus.java.pro.entities.Review;
import ru.otus.java.pro.repositories.ReviewsRepository;

import java.util.Date;
import java.util.List;

@Service
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public void createNewReview(CreateOrUpdateReviewDtoRq createOrUpdateReviewDtoRq) {
        Review newReview = new Review(null, createOrUpdateReviewDtoRq.getClientId(), createOrUpdateReviewDtoRq.getReviewText(), createOrUpdateReviewDtoRq.getGrade(), new Date(), createOrUpdateReviewDtoRq.getClientReviewedId());
        reviewsRepository.save(newReview);
    }

    public List<ReviewDto> findAllByClientId(@PathVariable Long id) {
        return reviewsRepository.findAllByClientId(id);
    }

    public void deleteById(Long id) {
        reviewsRepository.deleteById(id);
    }

    public void updateReviewTextById(Long id, String newReviewText) {
        reviewsRepository.changeMessageTextById(id, newReviewText);
    }
}
