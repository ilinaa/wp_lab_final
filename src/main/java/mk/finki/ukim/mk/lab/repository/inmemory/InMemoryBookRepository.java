package mk.finki.ukim.mk.lab.repository.inmemory;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.repository.jpa.AuthorRepository;
import mk.finki.ukim.mk.lab.repository.jpa.BookRepository;
import mk.finki.ukim.mk.lab.repository.jpa.BookStoreRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class InMemoryBookRepository {

    private final AuthorRepository authorRepository;

    public static List<Book> books = new ArrayList<>(5);

    private final BookStoreRepository bookStoreRepository;
    private final BookRepository bookRepository;

    public InMemoryBookRepository(AuthorRepository authorRepository, BookStoreRepository bookStoreRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookStoreRepository = bookStoreRepository;
        this.bookRepository = bookRepository;
        if(bookRepository.count() == 0) {
            List<BookStore> bookStores = bookStoreRepository.findAll();
            if(bookStores.size() >= 5){
                books.add(new Book("123", "Book1", "genre1", 2000, new ArrayList<>(), bookStoreRepository.findAll().get(0)));
                books.add(new Book("1234", "Book2", "genre2", 2001, new ArrayList<>(), bookStoreRepository.findAll().get(1)));
                books.add(new Book("12345", "Book3", "genre3", 2002, new ArrayList<>(), bookStoreRepository.findAll().get(2)));
                books.add(new Book("123456", "Book4", "genre4", 2003, new ArrayList<>(), bookStoreRepository.findAll().get(3)));
                books.add(new Book("1234567", "Book5", "genre5", 2004, new ArrayList<>(), bookStoreRepository.findAll().get(4)));
                bookRepository.saveAll(books);
            }
        }
    }


    public List<Book> findAll(){
        return this.books;
    }


    public Book findByIsbn(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public void deleteById(Long id){
        books.removeIf(b -> b.getId().equals(id));
    }

    public Optional<Book> findBookById (Long id){
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }
}