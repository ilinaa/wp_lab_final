package mk.finki.ukim.mk.lab.web.controller;
//
//import mk.finki.ukim.mk.lab.model.Book;
//import mk.finki.ukim.mk.lab.service.BookService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/book-details")
//public class BookDetailsController {
//    private final BookService bookService;
//
//    public BookDetailsController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @GetMapping
//    public String getBookDetailsPage(@RequestParam (required = false) String error, @RequestParam String isbn, Model model){
//        if (error != null && !error.isEmpty()){
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", error);
//        }
//        Book book = bookService.findBookByIsbn(isbn);
//        model.addAttribute("book", book);
//        model.addAttribute("authors", book.getAuthors());
//        return "bookDetails";
//    }
//
//    @PostMapping
//    public String postBookDetails(){
//        return "redirect:/book-details";
//    }
//}
//vpackage mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.model.Review;
import mk.finki.ukim.mk.lab.service.BookService;
import mk.finki.ukim.mk.lab.service.ReviewService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/book-details")
public class BookDetailsController {
    private final BookService bookService;
    private final ReviewService reviewService;

    public BookDetailsController(BookService bookService, ReviewService reviewService) {
        this.bookService = bookService;
        this.reviewService = reviewService;
    }

    @GetMapping
    public String getBookDetailsPage(@RequestParam(required = false) String error, @RequestParam String isbn, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
            return "redirect:/books?error=BookNotFound";
        }
        Book book = bookService.findBookByIsbn(isbn);
        Long bookId = book.getId();
        if(bookId != null){
            List<Review> reviews = reviewService.findReviewsByBookById(bookId);
            model.addAttribute("reviews", reviews);
            model.addAttribute("isbn", isbn);
            model.addAttribute("book", book);
            model.addAttribute("authors", book.getAuthors());
            return "bookDetails";
        }
        return "redirect:/books?error=BookNotFound";
    }

    @GetMapping(path={"/edit-review/{id}", "/add-review"})
    public String editReview(@RequestParam(required = false) String error, @PathVariable(required = false) Long id,@RequestParam(required = false) String isbn, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
            return "redirect:/books?error=BookNotFound";
        }
        if(this.reviewService.findReviewById(id) != null && id!=null) {
            Review review = reviewService.findReviewById(id);
            Book book = bookService.findBookById(id);
            model.addAttribute("review", review);
            model.addAttribute("isbn", book.getIsbn());
            model.addAttribute("book", book);

        }else {
            Book book = bookService.findBookByIsbn(isbn);
            model.addAttribute("book", book);
        }
            return "add-review";

    }

    @PostMapping("/add")
    public String saveReview(@RequestParam (name = "reviewId", required = false) Long reviewId,
                             @RequestParam Integer score,
                             @RequestParam String description,
                             @RequestParam (name = "bookId", required = false) Long bookId,
                             @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime timestamp
    )
    {
        Book book = bookService.findBookById(bookId);
        this.reviewService.saveReview(reviewId, score, description, bookId, timestamp);
        return "redirect:/book-details?isbn=" + book.getIsbn();
    }

//    @PostMapping
//    public String postBookDetails(){
//        return "redirect:/book-details";
//    }
}
