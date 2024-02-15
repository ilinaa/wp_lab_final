package mk.finki.ukim.mk.lab.repository.inmemory;

import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.repository.jpa.BookStoreRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBookStoreRepository {
    public static List<BookStore> bookStores = new ArrayList<>(5);
    private final BookStoreRepository bookStoreRepository;

    public InMemoryBookStoreRepository(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
        if(bookStoreRepository.count() == 0) {
            bookStores.add(new BookStore("Bookstore1", "City1", "Address1"));
            bookStores.add(new BookStore("Bookstore2", "City2", "Address2"));
            bookStores.add(new BookStore("Bookstore3", "City3", "Address3"));
            bookStores.add(new BookStore("Bookstore4", "City4", "Address4"));
            bookStores.add(new BookStore("Bookstore5", "City5", "Address5"));
            bookStoreRepository.saveAll(bookStores);
        }
    }

    public List<BookStore> findAll(){
        return this.bookStores;
    }

    public BookStore findBookStoreById(Long id){
        return bookStores.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
