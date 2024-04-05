package ru.otus.java.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.java.pro.dtos.CreateOrUpdateReviewDtoRq;
import ru.otus.java.pro.services.ReviewsService;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsController {
    private final ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @PostMapping
    public void createNewReview(@RequestBody CreateOrUpdateReviewDtoRq createOrUpdateReviewDtoRq) {
        reviewsService.createNewReview(createOrUpdateReviewDtoRq);
    }
}
