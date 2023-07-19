package com.example.springintro.repository;

import com.example.springintro.model.BookPrintInformation;
import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal minPrice, BigDecimal maxPrice);

    @Query("Select b from Book b where YEAR(b.releaseDate) <> :year")
    List<Book> findAllByReleaseDateNotInYear(@Param("year") int year);

    List<Book> findAllByTitleLike(String firstName);

    List<Book> findAllByAuthor_LastNameLike(String name);

    @Query("Select COUNT(b) from Book b where length(b.title) > :number")
    Integer findCountBooksWithTitleLonger(@Param("number") int number);


    @Query("select sum(b.copies) from Book b where b.author.firstName =:firstName and b.author.lastName = :lastName")
    Integer getCountCopiesForAuthor(String firstName, String lastName);


    @Query("SELECT new com.example.springintro.model.BookPrintInformation" +
            "(b.title, b.editionType, b.ageRestriction, b.price) from Book b where b.title = :title")
    List<BookPrintInformation> findAllByTitle(@Param("title") String title);

}
