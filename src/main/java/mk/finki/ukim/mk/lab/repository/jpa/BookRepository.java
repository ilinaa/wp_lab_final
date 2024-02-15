package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn) ;
    //Author addAuthorToBook(Optional<Author> authorOptional, Book book);
    Book findBookById(Long id);
    //Book saveBook(String isbn, String title, String genre, Integer year, Long bookId, Long bookStoreId);
}
