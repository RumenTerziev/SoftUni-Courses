package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Author;
import bg.softuni.bookshop.domain.entities.Book;
import bg.softuni.bookshop.repositories.AuthorRepository;
import bg.softuni.bookshop.repositories.BookRepository;
import bg.softuni.bookshop.utils.io.read.Reader;
import bg.softuni.bookshop.utils.io.read.ReaderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static bg.softuni.bookshop.domain.constants.FilePaths.AUTHORS_FILE_PATH;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;


    @Autowired
    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author getAuthorByName(String fullName) {
        String[] name = fullName.split("\\s+");
        String firstName = name[0];
        String lastName = name[1];
        Optional<Author> authorOpt = this.authorRepository.findByFirstNameAndLastName(firstName, lastName);

        if (authorOpt.isPresent()) {
            return authorOpt.get();
        }

        throw new RuntimeException("No author with given name was found!");

    }

    public List<Author> getAllAuthorsOrderedByBooksCount() {
        return this.authorRepository.findAllOrderByBooks();
    }

    public Set<Author> getAllAuthorsWithBooksBeforeYear(LocalDate localDate) {

        return this.bookRepository.findAllByReleaseDateBefore(localDate)
                .stream()
                .map(Book::getAuthor)
                .collect(Collectors.toSet());

    }

    public void seedAllAuthors() throws IOException {

        if (isDataSeeded()) {
            return;
        }

        Reader reader = ReaderManager.getFileReader(AUTHORS_FILE_PATH);

        String line = reader.readLine();

        while (line != null) {

            if (!line.trim().equals("")) {

                String[] data = line.split("\\s+");
                String firstName = data[0];
                String lastName = data[1];

                Author author = new Author();
                author.setFirstName(firstName);
                author.setLastName(lastName);

                this.authorRepository.save(author);
            }

            line = reader.readLine();
        }

    }

    public Author getRandomAuthor() {

        long count = this.authorRepository.count();

        if (count > 0) {
            Long random = ThreadLocalRandom.current().nextLong(1, count);
            return this.authorRepository.findById(random).get();
        }

        throw new RuntimeException("No authors found!");
    }

    private boolean isDataSeeded() {
        return this.authorRepository.count() > 0;
    }
}
