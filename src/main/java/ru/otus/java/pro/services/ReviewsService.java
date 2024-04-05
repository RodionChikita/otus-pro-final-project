package ru.otus.java.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.java.pro.dtos.CreateOrUpdateReviewDtoRq;
import ru.otus.java.pro.entities.Review;
import ru.otus.java.pro.repositories.ReviewsRepository;

import java.util.Date;

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
}
