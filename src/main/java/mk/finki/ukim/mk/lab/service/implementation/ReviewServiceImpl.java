package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.Review;
import mk.finki.ukim.mk.lab.repository.jpa.BookRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ReviewRepository;
import mk.finki.ukim.mk.lab.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> filterTimeStamp(LocalDateTime from, LocalDateTime to) {
        return reviewRepository.findByTimestampAfterAndTimestampBefore(from,to);
    }

    @Override
    public List<Review> findReviewsByBookById(Long id) {
        List<Review> allReviews = findAllReviews();
        System.out.println(allReviews);
        List<Review> itemsWithId = allReviews.stream()
                .filter(item ->item.getBook() != null && item.getBook().getId().equals(id))
                .collect(Collectors.toList());

        return itemsWithId;
    }

    @Override
    public Review saveReview(Long id, Integer score, String description, Long bookId,LocalDateTime timestamp) {
       // Review review = new Review(id,score,description,bookId);

        // Save the Review entity using the JpaRepository save method
       // return reviewRepository.save(review);
        Review review = reviewRepository.findReviewById(id);
        Book book = bookRepository.findBookById(bookId);
        if(review != null){
            reviewRepository.delete(review);
        }
        if (book != null ) {
            review = new Review(score, description, book, timestamp);
        }
        return reviewRepository.save(review);
    }

    @Override
    public Review findReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow();
    }
}
