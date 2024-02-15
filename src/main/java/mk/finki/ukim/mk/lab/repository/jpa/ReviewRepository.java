package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByTimestampAfterAndTimestampBefore(LocalDateTime from, LocalDateTime to);
    //Review saveReview(Long id,Integer score,String description,String isbn);

    List<Review> findBookById(Long id);//findByBook_Id
    Review findReviewById(Long id);
}
