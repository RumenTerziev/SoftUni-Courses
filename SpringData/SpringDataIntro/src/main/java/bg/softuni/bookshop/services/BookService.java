package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {

    List<Book> getAllBooksByAuthor(String searchedAuthor);

    List<Book> getAllBooksAfterYear(LocalDate localDate);

    void seedAllBooks() throws IOException;

    boolean isDataSeeded();
}
