package com.ananthudev.EasyCart.service.review;

import com.ananthudev.EasyCart.dto.review.CreateReviewDTO;
import com.ananthudev.EasyCart.dto.review.ResponseReviewDTO;
import com.ananthudev.EasyCart.dto.review.UpdateReviewDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReviewService {
    List<ResponseReviewDTO> getAllReviews();
    ResponseReviewDTO getReviewsById(Long id);
    List<ResponseReviewDTO> getReviewsByProductId(Long productId);
    List<ResponseReviewDTO> getReviewByCustomerId(Long customerId);
    ResponseReviewDTO createReview(CreateReviewDTO createReviewDTO);
    ResponseReviewDTO updateReview(Long id,UpdateReviewDTO updateReviewDTO);
    ResponseEntity<String> deleteReviewById(Long id);
}
