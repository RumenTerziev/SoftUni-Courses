package bg.softuni.bookshop.services.impl;

import bg.softuni.bookshop.domain.entities.Author;
import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.domain.entities.Category;
import bg.softuni.bookshop.domain.enums.AgeRestriction;
import bg.softuni.bookshop.domain.enums.EditionType;
import bg.softuni.bookshop.repositories.BookRepository;
import bg.softuni.bookshop.services.AuthorService;
import bg.softuni.bookshop.services.BookService;
import bg.softuni.bookshop.services.CategoryService;
import bg.softuni.bookshop.utils.io.read.Reader;
import bg.softuni.bookshop.utils.io.read.ReaderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static bg.softuni.bookshop.domain.constants.FilePaths.BOOKS_FILE_PATH;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorService authorService;

    private final CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorServiceImpl authorService, CategoryServiceImpl categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public List<Book> getAllBooksByAuthor(String searchedAuthor) {

        Author author = this.authorService.getAuthorByName(searchedAuthor);
        return this.bookRepository.findAllByAuthorOrderByReleaseDateDescTitleAsc(author);

    }

    @Override
    public List<Book> getAllBooksAfterYear(LocalDate localDate) {

        return this.bookRepository.findAllByReleaseDateAfter(localDate);

    }

    @Override
    public void seedAllBooks() throws IOException {

        if (isDataSeeded()) {
            return;
        }

        Reader reader = ReaderManager.getFileReader(BOOKS_FILE_PATH);

        String line = reader.readLine();

        while (line != null) {

            if (!line.trim().equals("")) {

                String[] data = line.split("\\s+");
                System.out.println(data[1]);

                Author author = authorService.getRandomAuthor();

                EditionType editionType =
                        EditionType.values()[Integer.parseInt(data[0])];

                LocalDate releaseDate = LocalDate.parse(data[1],
                        DateTimeFormatter.ofPattern("d/M/yyyy"));

                int copies = Integer.parseInt(data[2]);

                BigDecimal price = new BigDecimal(data[3]);

                AgeRestriction ageRestriction =
                        AgeRestriction.values()[Integer.parseInt(data[4])];

                String title = Arrays.stream(data)
                        .skip(5)
                        .collect(Collectors.joining(" "));

                Set<Category> categories = categoryService.getRandomCategories();

                Book book = new Book(
                        title,
                        null,
                        editionType,
                        price,
                        copies,
                        releaseDate,
                        ageRestriction,
                        author,
                        categories
                );

                this.bookRepository.save(book);

            }

            line = reader.readLine();

        }

    }

    @Override
    public boolean isDataSeeded() {
        return this.bookRepository.count() > 0;
    }
}
