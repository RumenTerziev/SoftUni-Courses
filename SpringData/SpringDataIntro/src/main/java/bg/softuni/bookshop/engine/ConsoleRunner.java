package bg.softuni.bookshop.engine;

import bg.softuni.bookshop.domain.entities.Author;
import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.services.AuthorService;
import bg.softuni.bookshop.services.BookService;
import bg.softuni.bookshop.services.CategoryService;
import bg.softuni.bookshop.utils.io.log.Logger;
import bg.softuni.bookshop.utils.io.log.LoggerManager;
import bg.softuni.bookshop.utils.io.read.Reader;
import bg.softuni.bookshop.utils.io.read.ReaderManager;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final Reader READER = ReaderManager.getSysInReader();
    private static final Logger LOGGER = LoggerManager.getSysOutLogger();

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;


    @Autowired
    private AuthorService authorService;


    @Override
    public void run(String... args) throws Exception {

        try {
            seedDatabase();
        } catch (IOException exception) {
            LOGGER.log(exception.getMessage());
        }


        LOGGER.log("Select The Number of Subtask that You want to test! From 1 - 4");


        int numberOfQuery = Integer.parseInt(READER.readLine());

        switch (numberOfQuery) {
            case 1 -> getAllBooksAfterYear();
            case 2 -> getAllAuthorsWithBooksReleasedBefore();
            case 3 -> getAllAuthorsSortedByBooks();
            case 4 -> getALlBooksFromAuthor();
            default -> LOGGER.log("No query with given number was found!");
        }


    }

    private void getALlBooksFromAuthor() {

        String searchedAuthorName = "George Powell";

        List<Book> allBooksByAuthor = this.bookService.getAllBooksByAuthor(searchedAuthorName);

        if (allBooksByAuthor.size() > 0) {
            allBooksByAuthor.forEach(b -> LOGGER.log(String.format("Title - %s, Release date - %s, Copies  %d",
                    b.getTitle(), b.getReleaseDate().toString(), b.getCopies())));
        } else {
            LOGGER.log("No books from given author were found!");
        }
    }

    private void getAllAuthorsWithBooksReleasedBefore() {

        LocalDate localDate = LocalDate.of(1990, 1, 1);

        List<Author> authors = this.authorService.getAllAuthorsWithBooksBeforeYear(localDate);

        if (authors.size() > 0) {
            authors.forEach(a -> LOGGER.log(a.getFirstName() + " " + a.getLastName()));
        } else {
            LOGGER.log("No authors matching given parameter were found!");
        }

    }

    private void getAllAuthorsSortedByBooks() {
        List<Author> allAuthorsSorted = this.authorService.getAllAuthorsOrderedByBooksCount();

        if (allAuthorsSorted.size() > 0) {
            allAuthorsSorted.forEach(a ->
                    LOGGER.log(
                            String.format("%s %s -> %d books",
                                    a.getFirstName(), a.getLastName(), a.getBooks().size())));

        } else {
            LOGGER.log("No authors were found!");
        }
    }

    private void getAllBooksAfterYear() {
        LocalDate localDate = LocalDate.of(2000, 12, 31);
        List<Book> allBooksAfterYear = this.bookService.getAllBooksAfterYear(localDate);

        if (allBooksAfterYear.size() > 0) {
            allBooksAfterYear.forEach(b -> LOGGER.log(b.getTitle()));
        } else {
            LOGGER.log("No books matching given parameter were found!");
        }
    }


    private void seedDatabase() throws IOException {

        this.authorService.seedAllAuthors();
        this.categoryService.seedAllCategories();
        this.bookService.seedAllBooks();

    }

}
