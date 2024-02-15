package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.repository.jpa.AuthorRepository;
import mk.finki.ukim.mk.lab.repository.jpa.BookRepository;
import mk.finki.ukim.mk.lab.repository.jpa.BookStoreRepository;
import mk.finki.ukim.mk.lab.service.BookService;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final BookStoreRepository bookStoreRepository;

    public BookServiceImplementation(BookRepository bookRepository, AuthorRepository authorRepository, BookStoreRepository bookStoreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookStoreRepository = bookStoreRepository;

    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addAuthorToBook(Long authorId, String isbn) {
       Optional<Author> author = authorRepository.findById(authorId);
        Book book = bookRepository.findByIsbn(isbn);
        if (book!= null && author.isPresent()){
            Author author1 = author.get();
            if (!book.getAuthors().contains(author1)){
                book.getAuthors().add(author1);
                return bookRepository.save(book);
            }
        }

        return null;
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public Book saveBook(String isbn, String title, String genre, Integer year,Long bookId, Long bookStoreid) {

        Book book = bookRepository.findBookById(bookId);
        if (book !=null){
            bookRepository.delete(book);
        }
        BookStore bookStore = bookStoreRepository.findBookStoreById(bookStoreid);
        book = new Book(title, isbn, genre, year,new ArrayList<>(), bookStore);
        return bookRepository.save(book);
    }

}
