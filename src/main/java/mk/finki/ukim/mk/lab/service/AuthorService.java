package mk.finki.ukim.mk.lab.service;


import mk.finki.ukim.mk.lab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAllAuthors();
    Optional<Author> findAuthorById(Long id);
}
