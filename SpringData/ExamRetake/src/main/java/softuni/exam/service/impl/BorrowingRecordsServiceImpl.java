package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Genre;
import softuni.exam.models.dto.BorrowingRecordsExportDto;
import softuni.exam.models.dto.BorrowingRecordsImportDto;
import softuni.exam.models.dto.BorrowingRecordsListImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecords;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private static final String BORROWING_RECORDS_FILE_PATH = "src/main/resources/files/xml/borrowing-records.xml";

    private BorrowingRecordRepository borrowingRecordRepository;

    private BookRepository bookRepository;

    private LibraryMemberRepository libraryMemberRepository;

    private ModelMapper modelMapper;

    @Autowired
    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, BookRepository bookRepository, LibraryMemberRepository libraryMemberRepository, ModelMapper modelMapper) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(BORROWING_RECORDS_FILE_PATH));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {

        if (areImported()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(BorrowingRecordsListImportDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(BORROWING_RECORDS_FILE_PATH));
        BorrowingRecordsListImportDto borrowingRecordsListImportDto =
                (BorrowingRecordsListImportDto) unmarshaller.unmarshal(bufferedReader);


        for (BorrowingRecordsImportDto borrowingRecordsImportDto : borrowingRecordsListImportDto.getBorrowingRecords()) {

            if (!borrowingRecordsImportDto.isValid()) {
                stringBuilder.append("Invalid borrowing record").append(System.lineSeparator());
                continue;
            }

            List<Book> allByBookTitle = bookRepository.findAllByTitle(borrowingRecordsImportDto.getBook().getTitle());

            if (allByBookTitle.isEmpty()) {
                stringBuilder.append("Invalid borrowing record").append(System.lineSeparator());
                continue;
            }

            Optional<LibraryMember> memberOptional = libraryMemberRepository.findById(borrowingRecordsImportDto.getMember().getId());

            if (memberOptional.isEmpty()) {
                stringBuilder.append("Invalid borrowing record").append(System.lineSeparator());
                continue;
            }

            BorrowingRecords borrowingRecords = modelMapper.map(borrowingRecordsImportDto, BorrowingRecords.class);
            borrowingRecords.setBook(allByBookTitle.get(0));
            borrowingRecords.setMember(memberOptional.get());
            borrowingRecordRepository.save(borrowingRecords);
            stringBuilder.append(String.format("Successfully imported borrowing record %s - %s%n",
                    borrowingRecords.getBook().getTitle(),
                    borrowingRecords.getBorrowDate()));
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportBorrowingRecords() {

        List<BorrowingRecords> borrowingRecords = borrowingRecordRepository
                .findAllByBook_GenreOrderByBorrowDateDesc(Genre.SCIENCE_FICTION);

        List<BorrowingRecordsExportDto> exportDtos =
                borrowingRecords.stream()
                        .map(record -> modelMapper.map(record, BorrowingRecordsExportDto.class))
                        .collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();
        exportDtos.forEach(stringBuilder::append);
        return stringBuilder.toString().trim();
    }
}
