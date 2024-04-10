package ru.otus.java.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reviewsService.deleteById(id);
    }

    @PatchMapping("/{id}/messageText")
    public void updateReviewTextById(@PathVariable Long id, @RequestParam String value) {
        reviewsService.updateReviewTextById(id, value);
    }
}
