////package mk.finki.ukim.mk.lab.web.controller;
////
////import mk.finki.ukim.mk.lab.model.Book;
////import mk.finki.ukim.mk.lab.model.BookStore;
////import mk.finki.ukim.mk.lab.service.BookService;
////import mk.finki.ukim.mk.lab.service.BookStoreService;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////
////@Controller
////@RequestMapping("/books")
////public class BookController {
////    private final BookService bookService;
////    private final BookStoreService bookStoreService;
////
////    public BookController(BookService bookService,   BookStoreService bookStoreService){
////        this.bookService = bookService;
////        this.bookStoreService = bookStoreService;
////    }
////
////    @GetMapping()
////    public String getBookPage(@RequestParam(required = false) String error, Model model) {
////        if (error != null && !error.isEmpty()) {
////            model.addAttribute("hasError", true);
////            model.addAttribute("error", error);
////        }
////        List<Book> books = this.bookService.listBooks();
////        model.addAttribute("books", books);
////        return "listBooks";
////    }
////
////    @GetMapping("/add-form")
////    public String getAddBookPage(@RequestParam(required = false) String error, Model model){
////        if (error != null && !error.isEmpty()) {
////            model.addAttribute("hasError", true);
////            model.addAttribute("error", error);
////        }
////        List<Book> books = this.bookService.listBooks();
////        List<BookStore> bookstores = this.bookStoreService.findAll();
////        model.addAttribute("books", books);
////        model.addAttribute("bookstores", bookstores);
////        return "add-book";
////    }
////    @GetMapping("/edit-form/{id}")
////    public String editBook(@PathVariable Long id,Model model){
////        if (this.bookService.findBookById(id).isPresent()) {
////            Book book = this.bookService.findBookById(id).get();
////            List<BookStore> bookStores = bookStoreService.findAll();
////            model.addAttribute("book", book);
////            model.addAttribute("bookStores", bookStores);
////            return "add-book";
////        }
////        return "redirect:/books?error=BookNotFound";
////    }
////
////
////
////
////    @PostMapping("/add")
////    public String saveBook(@RequestParam String isbn,
////                           @RequestParam String title,
////                           @RequestParam String genre,
////                           @RequestParam Integer year,
////                           @RequestParam (name = "bookId", required = false) Long bookId,
////                           @RequestParam Long bookStoreId){
////        this.bookService.saveBook(isbn,title,genre,year,bookId,bookStoreId);
////        return "redirect:/books";
////    }
////
////
////    @GetMapping("/delete/{id}")
////    public String deleteBook(@PathVariable Long id) {
////        this.bookService.deleteById(id);
////        return "redirect:/books";
////    }
////    @PostMapping()
////    public String redirectToAuthosPage(@RequestParam String bookIsbn){
////        return  "redirect:/authors?isbn=" + bookIsbn;
////    }
////
////
////
////}
//
//package mk.finki.ukim.mk.lab.web.controller;
//
//import mk.finki.ukim.mk.lab.model.Book;
//import mk.finki.ukim.mk.lab.model.BookStore;
//import mk.finki.ukim.mk.lab.service.BookService;
//import mk.finki.ukim.mk.lab.service.BookStoreService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/books")
//public class BookController{
//    private final BookService bookService;
//    private final BookStoreService bookStoreService;
//
//    public BookController(BookService bookService, BookStoreService bookStoreService) {
//        this.bookService = bookService;
//        this.bookStoreService = bookStoreService;
//    }
//
//    @GetMapping
//    public String getBookPage(@RequestParam(required = false) String error, Model model){
//        if (error != null && !error.isEmpty()) {
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", error);
//        }
//        List<Book> books = this.bookService.findAllBooks();
//        model.addAttribute("books", books);
//        return "listBooks";
//    }
//
//
//
//    @GetMapping("/add-form")
//    public String getAddBookPage(@RequestParam(required = false) String error, Model model){
//        if (error != null && !error.isEmpty()) {
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", error);
//        }
//        List<Book> books = this.bookService.findAllBooks();
//        List<BookStore> bookstores = this.bookStoreService.findAll();
//        model.addAttribute("books", books);
//        model.addAttribute("bookstores", bookstores);
//        return "add-book";
//    }
//
//    @GetMapping("/edit-form/{id}")
//    public String editBook(@PathVariable Long id, Model model) {
//        if (this.bookService.findBookById(id).isPresent()) {
//            Book book = this.bookService.findBookById(id).get();
//            List<BookStore> bookstores = bookStoreService.findAll();
//            model.addAttribute("bookstores", bookstores);
//            model.addAttribute("book", book);
//            return "add-book";
//        }
//        return "redirect:/books?error=BookNotFound";
//    }
//
//    @PostMapping("/add")
//    public String saveBook(@RequestParam String isbn,
//                           @RequestParam String title,
//                           @RequestParam String genre,
//                           @RequestParam Integer year,
//                           @RequestParam (name = "bookId", required = false) Long bookId,
//                           @RequestParam Long bookStoreId) {
//        this.bookService.saveBook(isbn, title, genre, year, String.valueOf(bookId), bookStoreId);
//        return "redirect:/books";
//    }
//    @GetMapping("/delete/{id}")
//    public String deleteBook(@PathVariable Long id) {
//        this.bookService.deleteById(id);
//        return "redirect:/books";
//    }
//
//    @PostMapping()
//    public String redirectToAuthorsPage(@RequestParam String bookIsbn){
//        return "redirect:authors?isbn=" + bookIsbn;
//    }
//}
package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.model.Review;
import mk.finki.ukim.mk.lab.service.BookService;
import mk.finki.ukim.mk.lab.service.BookStoreService;
import mk.finki.ukim.mk.lab.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController{
    private final BookService bookService;
    private final BookStoreService bookStoreService;

    public BookController(BookService bookService, BookStoreService bookStoreService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;

    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Book> books = this.bookService.findAllBooks();
        model.addAttribute("books", books);
        return "listBooks";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return "redirect:/books";
    }

    //    @GetMapping("/add-form")
//    public String getAddBookPage(@RequestParam(required = false) String error, Model model){
//        if (error != null && !error.isEmpty()) {
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", error);
//        }
//        List<Book> books = this.bookService.listBooks();
//        List<BookStore> bookstores = this.bookStoreService.findAll();
//        model.addAttribute("books", books);
//        model.addAttribute("bookstores", bookstores);
//        return "add-book";
//    }
//    @GetMapping("/edit-form/{id}")
//    public String getEditBookForm(@PathVariable Long id, Model model) {
//        if (this.bookService.findBookById(id).isPresent()) {
//            Book book = this.bookService.findBookById(id).get();
//            List<BookStore> bookstores = bookStoreService.findAll();
//            model.addAttribute("bookstores", bookstores);
//            model.addAttribute("book", book);
//            return "add-book";
//        }
//        return "redirect:/books?error=BookNotFound";
//    }
    @GetMapping(path={"/edit-form/{id}", "/add-form"})
    public String editBook(@RequestParam(required = false) String error, @PathVariable(required = false) Long id, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
            return "redirect:/books?error=BookNotFound";
        }
        List<BookStore> bookstores = bookStoreService.findAll();
        model.addAttribute("bookstores", bookstores);
        if (this.bookService.findBookById(id) != null && id!=null) {
            Book book = this.bookService.findBookById(id);
            model.addAttribute("book", book);
            return "add-book";
        }else{
            List<Book> books = this.bookService.findAllBooks();
            model.addAttribute("books", books);
            return "add-book";
        }
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String isbn,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Integer year,
                           @RequestParam (name = "bookId", required = false) Long bookId,
                           @RequestParam Long bookStoreId) {
        this.bookService.saveBook(isbn, title, genre, year, bookId, bookStoreId);
        return "redirect:/books";
    }

    @PostMapping()
    public String redirectToAuthorsPage(@RequestParam String bookIsbn){
        return "redirect:authors?isbn=" + bookIsbn;
    }
}
