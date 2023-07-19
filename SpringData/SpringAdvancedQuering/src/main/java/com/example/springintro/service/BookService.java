package com.example.springintro.service;

import com.example.springintro.model.BookPrintInformation;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(String ageRestriction);

    List<Book> findAllByEditionTypeAndCopies(String editionType, Integer copies);

    List<Book> findAllByPriceNotBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Book> findAllNotReleasedIn(int releasedYear);

    List<Book> findAllBooksReleasedBeforeDate(String searchedDate);

    List<Book> getAllBooksWithTitleLike(String pattern);

    List<Book> getAllBooksWithAuthorLike(String pattern);

    Integer getAllBooksWithTitleLengthLonger(int searchedLength);

    List<String> getAllBooksCopiesByAuthor();

    List<BookPrintInformation> getAllBookInformationByTitle(String title);

}
