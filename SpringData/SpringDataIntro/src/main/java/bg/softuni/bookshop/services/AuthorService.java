package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Author;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AuthorService {

    Author getAuthorByName(String fullName);

    List<Author> getAllAuthorsOrderedByBooksCount();

    Set<Author> getAllAuthorsWithBooksBeforeYear(LocalDate localDate);

    void seedAllAuthors() throws IOException;

    Author getRandomAuthor();

    boolean isDataSeeded();
}
