package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.io.read.FileReader;

import java.io.IOException;

import static softuni.exam.models.constants.JsonPath.COUNTRY_FILE_PATH;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private Gson gson;

    @Autowired
    private FileReader fileReader;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {

        return this.fileReader.readAllData(COUNTRY_FILE_PATH);
    }

    @Override
    public String importCountries() throws IOException {

        if (this.areImported()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        String json = this.readCountriesFromFile();

        CountryImportDto[] countryImportDtos = this.gson.fromJson(json, CountryImportDto[].class);


        for (CountryImportDto countryDto : countryImportDtos) {

            if (countryDto.isValid() && this.countryRepository.findFirstByCountryName(countryDto.getCountryName()).isEmpty()) {
                Country country = this.modelMapper.map(countryDto, Country.class);
                this.countryRepository.save(country);
                stringBuilder.append(
                        String.format("Successfully imported country %s - %s%n",
                                country.getCountryName(), country.getCurrency()));

            } else {
                stringBuilder.append("Invalid country")
                        .append(System.lineSeparator());
            }

        }

        return stringBuilder.toString().trim();
    }
}
