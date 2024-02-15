package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.repository.jpa.BookStoreRepository;
import mk.finki.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreServiceImplementation implements BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    public BookStoreServiceImplementation(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }


    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }

    @Override
    public BookStore findBookStoreById(Long id) {
        return this.bookStoreRepository.findBookStoreById(id);
    }

}
