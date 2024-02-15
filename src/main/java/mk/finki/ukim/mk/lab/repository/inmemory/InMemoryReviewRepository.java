package mk.finki.ukim.mk.lab.repository.inmemory;

import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.model.Review;
import mk.finki.ukim.mk.lab.repository.jpa.BookRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ReviewRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryReviewRepository {
    public static List<Review> reviews = new ArrayList<>();

    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;
    public InMemoryReviewRepository(BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;

        if(reviewRepository.count() == 0){
            LocalDateTime now = LocalDateTime.now();
            reviews.add(new Review(5, "very good book", bookRepository.findAll().get(0), now));
            reviews.add(new Review(4, "nice book", bookRepository.findAll().get(1), now));
            reviews.add(new Review(2, "very bad book",bookRepository.findAll().get(2), now));
            reviews.add(new Review(3, "average book", bookRepository.findAll().get(3), now));
            reviewRepository.saveAll(reviews);
        }
    }


    public List<Review> findAllByTimestampBetween(LocalDateTime from, LocalDateTime to){
        return reviews.stream().filter(r -> r.getTimestamp().isAfter(from) && r.getTimestamp().isBefore(to)).collect(Collectors.toList());
    }

    public List<Review> findBookById(Long id){
        return reviews.stream().filter(r -> r.getBook().getId().equals(id)).collect(Collectors.toList());
    }

    public Review findReviewById(Long id){
        return reviews.stream().filter(r -> r.getId().equals(id)).findFirst().orElseThrow();
    }
}
