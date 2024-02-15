package mk.finki.ukim.mk.lab.service;


import mk.finki.ukim.mk.lab.model.Review;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews();
    List<Review> filterTimeStamp(LocalDateTime from, LocalDateTime to);
    List<Review>findReviewsByBookById(Long id);
    Review saveReview(Long id,Integer score,String description,Long bookId,LocalDateTime timestamp);
    Review findReviewById(Long id);
}

