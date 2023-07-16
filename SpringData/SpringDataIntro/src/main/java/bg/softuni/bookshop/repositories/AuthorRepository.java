package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.domain.entities.Author;
import bg.softuni.bookshop.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query("Select a from Author a order by size(a.books) desc")
    List<Author> findAllOrderByBooks();

    @Query("Select a from Author a where a.books in :books")
    List<Author> findAllByBooks(@Param("books") Set<Book> books);

    Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);

}
