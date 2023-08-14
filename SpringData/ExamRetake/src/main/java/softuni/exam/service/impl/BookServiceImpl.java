package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/json/books.json";

    private BookRepository bookRepository;

    private Gson gson;

    private ModelMapper modelMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, Gson gson, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(BOOKS_FILE_PATH));
    }

    @Override
    public String importBooks() throws IOException {

        if (areImported()) {
            return "";
        }

        BookImportDto[] bookImportDtos = this.gson.fromJson(readBooksFromFile(), BookImportDto[].class);

        StringBuilder stringBuilder = new StringBuilder();

        for (BookImportDto bookImportDto : bookImportDtos) {

            if (!bookImportDto.isValid()) {
                stringBuilder.append("Invalid book").append(System.lineSeparator());
                continue;
            }

            List<Book> allByTitle = bookRepository.findAllByTitle(bookImportDto.getTitle());

            if (!allByTitle.isEmpty()) {
                stringBuilder.append("Invalid book").append(System.lineSeparator());
                continue;
            }

            Book book = modelMapper.map(bookImportDto, Book.class);
            bookRepository.save(book);
            stringBuilder.append(String.format("Successfully imported book %s - %s%n",
                    book.getAuthor(),
                    book.getTitle()));
        }

        return stringBuilder.toString().trim();
    }
}
