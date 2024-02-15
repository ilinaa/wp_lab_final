package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);

    void deleteById(Long id);
    Book findBookById (Long id);
    Book saveBook(String isbn, String title, String genre, Integer year,Long bookId, Long bookStoreid);

}
