package mk.finki.ukim.mk.lab.repository.inmemory;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.repository.jpa.AuthorRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryAuthorRepository {
    public static List<Author> authors = new ArrayList<>(5);

    private final AuthorRepository authorRepository;

    public InMemoryAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        authors =  new ArrayList<>();
        if(authorRepository.count() == 0){
            authors.add(new Author("Author1", "Surname1", "bio1"));
            authors.add(new Author("Author2", "Surname2", "bio2"));
            authors.add(new Author("Author3", "Surname3", "bio3"));
            authors.add(new Author("Author4", "Surname4", "bio4"));
            authors.add(new Author("Author5", "Surname5", "bio5"));
            authorRepository.saveAll(authors);
        }

    }

    public List<Author> findAll(){
        return this.authors;
    }

    public Optional<Author> findById(Long id) {
        return authors.stream().filter(a -> a.getId().equals(id)).findFirst();
    }
}
