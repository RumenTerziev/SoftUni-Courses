package softuni.exam.models.dto;

import softuni.exam.models.Genre;

public class BookImportDto {

    private String title;

    private String author;

    private String description;

    private boolean available;

    private Genre genre;

    private Double rating;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return available;
    }

    public Genre getGenre() {
        return genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public boolean isValid() {

        if (author == null) {
            return false;
        }

        if (title == null) {
            return false;
        }

        if (description == null) {
            return false;
        }

        if (genre == null) {
            return false;
        }

        if (rating == null) {
            return false;
        }

        if (title.length() < 3 || title.length() > 40) {
            return false;
        }

        if (author.length() < 3 || author.length() > 40) {
            return false;
        }

        if (description.length() < 5) {
            return false;
        }

        return rating > 0;
    }
}
