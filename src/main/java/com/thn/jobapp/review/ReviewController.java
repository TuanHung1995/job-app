package com.thn.jobapp.review;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,
            @RequestBody Review review) {
        boolean reviewAdded = reviewService.addReview(companyId, review);
        if (!reviewAdded)
            return new ResponseEntity<>("Review not added!", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Review added successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(
            @PathVariable Long companyId,
            @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReviewById(companyId, reviewId), HttpStatus.OK);
    }

}
