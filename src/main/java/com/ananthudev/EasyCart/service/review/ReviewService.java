package com.ananthudev.EasyCart.service.review;

import com.ananthudev.EasyCart.dto.review.CreateReviewDTO;
import com.ananthudev.EasyCart.dto.review.ResponseReviewDTO;
import com.ananthudev.EasyCart.dto.review.UpdateReviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements IReviewService {
    @Override
    public List<ResponseReviewDTO> getAllReviews() {
        return List.of();
    }

    @Override
    public ResponseReviewDTO getReviewsById(Long id) {
        return null;
    }

    @Override
    public List<ResponseReviewDTO> getReviewsByProductId(Long productId) {
        return List.of();
    }

    @Override
    public List<ResponseReviewDTO> getReviewByCustomerId(Long customerId) {
        return List.of();
    }

    @Override
    public ResponseReviewDTO createReview(CreateReviewDTO createReviewDTO) {
        return null;
    }

    @Override
    public ResponseReviewDTO updateReview(Long id,UpdateReviewDTO updateReviewDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteReviewById(Long id) {
        return null;
    }
}
