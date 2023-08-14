package softuni.exam.models.entity;

import softuni.exam.models.Genre;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "available", nullable = false)
    private boolean available;

    @Column(name = "Genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "rating", nullable = false)
    private Double rating;


    @OneToMany(targetEntity = BorrowingRecords.class, mappedBy = "book")
    private List<BorrowingRecords> records;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<BorrowingRecords> getRecords() {
        return records;
    }

    public void setRecords(List<BorrowingRecords> records) {
        this.records = records;
    }
}
