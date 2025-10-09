package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.review.CreateReviewDTO;
import com.ananthudev.EasyCart.dto.review.ResponseReviewDTO;
import com.ananthudev.EasyCart.dto.review.UpdateReviewDTO;
import com.ananthudev.EasyCart.service.review.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }


    @GetMapping("/reviews")
    public List<ResponseReviewDTO> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/reviews/{id}")
    public ResponseReviewDTO getReviewById(@PathVariable Long id){
        return reviewService.getReviewsById(id);
    }

    @GetMapping("/reviews/product/{productId}")
    public List<ResponseReviewDTO> getReviewsByProductId(@PathVariable Long productId){
        return reviewService.getReviewsByProductId(productId);
    }

    @GetMapping("/reviews/customer/{customerId}")
    public List<ResponseReviewDTO> getReviewsByCustomerId(@PathVariable Long customerId){
            return reviewService.getReviewByCustomerId(customerId);
    }

    @PostMapping("/reviews")
    public ResponseReviewDTO createReviews(@RequestBody CreateReviewDTO createReviewDTO){
            return reviewService.createReview(createReviewDTO);
    }

    @PutMapping("/reviews/{id}")
    public ResponseReviewDTO updateReviewById(@PathVariable Long id, @RequestBody UpdateReviewDTO updateReviewDTO){
        return reviewService.updateReview(id,updateReviewDTO);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long id){
            return reviewService.deleteReviewById(id);
    }
}
