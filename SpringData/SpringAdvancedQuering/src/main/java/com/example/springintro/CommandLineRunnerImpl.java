package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private static final Scanner SCANNER = new Scanner(System.in);

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
//
//        printAllBooksByAgeRestriction();
//        printAllBooksByEditionTypeAndCopies();
//        printAllBooksWithPriceNotBetween();
//        printAllBooksNotReleasedIn();
//        printBookInformationForBooksReleasedAfter();
//        printAllAuthorsWhoseFirstNameMatches();
//        printAllBooksWithTitleLike();
//        printAllBooksWithAuthorLike();
//        printCountOfBooksWithTitleLonger();
//        printAllAuthorsWithCountCopies();
        printAllBookInformationByTitle();



    }


    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        this.bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        this.authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        this.bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        this.bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void printAllBooksNotReleasedIn() {

        System.out.println("Please enter a year to search by!");
        int year = Integer.parseInt(SCANNER.nextLine());

        this.bookService
                .findAllNotReleasedIn(year)
                .forEach(b -> System.out.println(b.getTitle()));

    }


    private void printAllBooksWithPriceNotBetween() {

        BigDecimal minPrice = BigDecimal.valueOf(5);
        BigDecimal maxPrice = BigDecimal.valueOf(40);

        this.bookService.findAllByPriceNotBetween(minPrice, maxPrice)
                .forEach(b -> System.out.printf("%s - $%s%n", b.getTitle(), b.getPrice()));

    }


    private void printAllBooksByEditionTypeAndCopies() {
        String searchedType = "Gold";
        int searchedCopies = 5000;

        this.bookService
                .findAllByEditionTypeAndCopies(searchedType, searchedCopies)
                .forEach(b -> System.out.println(b.getTitle()));

    }


    private void printAllBooksByAgeRestriction() {

        System.out.println("Please enter a restriction to search by!");
        String searchedRestriction = SCANNER.nextLine();

        this.bookService
                .findAllByAgeRestriction(searchedRestriction)
                .forEach(b -> System.out.println(b.getTitle()));

    }


    private void printBookInformationForBooksReleasedAfter() {

        System.out.println("Please enter date to search by in format  dd-MM-yyyy.");
        String searchedDate = SCANNER.nextLine();

        this.bookService
                .findAllBooksReleasedBeforeDate(searchedDate)
                .forEach(b ->
                        System.out.printf("%s %s %s%n",
                                b.getTitle(),
                                b.getEditionType().name(),
                                b.getPrice()));

    }

    private void printAllAuthorsWhoseFirstNameMatches() {

        System.out.println("Please enter a pattern to search for in Author's first name!");
        String pattern = SCANNER.nextLine();

        this.authorService.getAllAuthorsWhoseFirstNameLike(pattern)
                .forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));
    }


    private void printAllBooksWithTitleLike() {

        System.out.println("Please enter a pattern to search for in book's title!");
        String pattern = SCANNER.nextLine();

        this.bookService.getAllBooksWithTitleLike(pattern)
                .forEach(b -> System.out.println(b.getTitle()));
    }


    private void printAllBooksWithAuthorLike() {

        System.out.println("Please enter a pattern to search for books with Author whose last name matches it!");
        String pattern = SCANNER.nextLine();

        this.bookService
                .getAllBooksWithAuthorLike(pattern)
                .forEach(b -> System.out.printf("%s (%s %s)%n",
                        b.getTitle(),
                        b.getAuthor().getFirstName(),
                        b.getAuthor().getLastName()));
    }


    private void printCountOfBooksWithTitleLonger() {

        System.out.println("Please enter a number to compare with the books' titles' length!");
        int searchedLength = Integer.parseInt(SCANNER.nextLine());

        Integer count = this.bookService.getAllBooksWithTitleLengthLonger(searchedLength);

        System.out.println(count);

    }


    private void printAllAuthorsWithCountCopies() {

        this.bookService.getAllBooksCopiesByAuthor()
                .forEach(System.out::println);

    }


    private void printAllBookInformationByTitle() {
        System.out.println("Please enter a title to search by!");
        String title = SCANNER.nextLine();

        this.bookService.getAllBookInformationByTitle(title)
                .forEach(System.out::println);
    }


    private void seedData() throws IOException {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();
    }
}