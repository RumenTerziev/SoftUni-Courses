package com.example.springintro.service.impl;

import com.example.springintro.model.BookPrintInformation;
import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllByAgeRestriction(String ageRestriction) {

        return this.bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase()));

    }

    @Override
    public List<Book> findAllByEditionTypeAndCopies(String editionType, Integer copies) {

        return this.bookRepository
                .findAllByEditionTypeAndCopiesLessThan(EditionType.valueOf(editionType.toUpperCase()), copies);

    }

    @Override
    public List<Book> findAllByPriceNotBetween(BigDecimal minPrice, BigDecimal maxPrice) {

        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(minPrice, maxPrice);

    }

    @Override
    public List<Book> findAllNotReleasedIn(int releasedYear) {

        return this.bookRepository.findAllByReleaseDateNotInYear(releasedYear);

    }

    @Override
    public List<Book> findAllBooksReleasedBeforeDate(String searchedDate) {

        String[] dateParts = searchedDate.split("-");
        int date = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        LocalDate localDate = LocalDate.of(year, month, date);

        return this.bookRepository.findAllByReleaseDateBefore(localDate);
    }

    @Override
    public List<Book> getAllBooksWithTitleLike(String pattern) {

        return this.bookRepository.findAllByTitleLike("%" + pattern + "%");

    }

    @Override
    public List<Book> getAllBooksWithAuthorLike(String pattern) {


        return this.bookRepository.findAllByAuthor_LastNameLike(pattern + "%");

    }

    @Override
    public Integer getAllBooksWithTitleLengthLonger(int searchedLength) {

        return this.bookRepository.findCountBooksWithTitleLonger(searchedLength);

    }

    @Override
    public List<String> getAllBooksCopiesByAuthor() {

        List<Author> allAuthors = this.authorService.getAllAuthors();
        List<String> resultList = new ArrayList<>();

        for (Author author : allAuthors) {

            Integer countCopiesForAuthor =
                    this.bookRepository.getCountCopiesForAuthor(author.getFirstName(), author.getLastName());

            resultList.add(String.format("%s %s - %d",
                    author.getFirstName(),
                    author.getLastName(),
                    countCopiesForAuthor));

        }

        return resultList;
    }

    @Override
    public List<BookPrintInformation> getAllBookInformationByTitle(String title) {

        return this.bookRepository.findAllByTitle(title);
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
