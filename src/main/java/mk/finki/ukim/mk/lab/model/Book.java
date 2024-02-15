package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    public String isbn;
    @Column(nullable = false)
    public String title;
    public String genre;
    public int year;
    @ManyToMany //beshe @manytomany
    @JoinTable(name = "authors-of-books")
    public List<Author> authors;
    @ManyToOne
    @JoinColumn(referencedColumnName = "book_store_id")
    private BookStore bookStore;


    public Book( String isbn, String title, String genre, int year,List<Author> authors, BookStore bookStore) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = new ArrayList<>();
        this.bookStore = bookStore;
    }



    public Book() {

    }
}

