package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMemberImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

    private static final String LIBRARY_MEMBERS_FILE_PATH = "src/main/resources/files/json/library-members.json";

    private LibraryMemberRepository libraryMemberRepository;

    private Gson gson;

    private ModelMapper modelMapper;

    @Autowired
    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, Gson gson, ModelMapper modelMapper) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(LIBRARY_MEMBERS_FILE_PATH));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        if (areImported()) {
            return "";
        }

        LibraryMemberImportDto[] libraryMemberImportDtos =
                this.gson.fromJson(readLibraryMembersFileContent(), LibraryMemberImportDto[].class);

        StringBuilder stringBuilder = new StringBuilder();

        for (LibraryMemberImportDto libraryMemberImportDto : libraryMemberImportDtos) {

            if (!libraryMemberImportDto.isValid()) {
                stringBuilder.append("Invalid library member").append(System.lineSeparator());
                continue;
            }

            List<LibraryMember> allByPhoneNumber = libraryMemberRepository
                    .findAllByPhoneNumber(libraryMemberImportDto.getPhoneNumber());

            if (!allByPhoneNumber.isEmpty()) {
                stringBuilder.append("Invalid library member").append(System.lineSeparator());
                continue;
            }

            LibraryMember libraryMember = modelMapper.map(libraryMemberImportDto, LibraryMember.class);
            libraryMemberRepository.save(libraryMember);
            stringBuilder.append(String.format("Successfully imported library member %s - %s%n",
                    libraryMember.getFirstName(),
                    libraryMember.getLastName()));
        }

        return stringBuilder.toString().trim();
    }
}
