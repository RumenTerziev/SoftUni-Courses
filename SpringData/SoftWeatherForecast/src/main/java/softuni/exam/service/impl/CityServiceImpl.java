package softuni.exam.service.impl;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.io.read.FileReader;

import java.io.IOException;
import java.util.Optional;

import static softuni.exam.models.constants.JsonPath.CITY_FILE_PATH;

@Service
public class CityServiceImpl implements CityService {


    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private FileReader fileReader;

    @Autowired
    private Gson gson;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public boolean areImported() {

        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {

        return this.fileReader.readAllData(CITY_FILE_PATH);

    }

    @Override
    public String importCities() throws IOException {


        if (this.areImported()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        String json = this.readCitiesFileContent();

        CityImportDto[] cityImportDtos = this.gson.fromJson(json, CityImportDto[].class);


        for (CityImportDto cityImportDto : cityImportDtos) {

            if (!cityImportDto.isValid()) {

                stringBuilder.append("Invalid city")
                        .append(System.lineSeparator());
                continue;
            }

            Optional<Country> firstById = this.countryRepository.findFirstById(cityImportDto.getCountry());

            if (firstById.isEmpty()) {
                stringBuilder.append("Invalid city")
                        .append(System.lineSeparator());
                continue;
            }


            Optional<City> firstByCityName = this.cityRepository.findFirstByCityName(cityImportDto.getCityName());


            if (firstByCityName.isPresent()) {
                stringBuilder.append("Invalid city")
                        .append(System.lineSeparator());
                continue;
            }

            City city = this.modelMapper.map(cityImportDto, City.class);

            city.setCountry(firstById.get());

            this.cityRepository.save(city);
            stringBuilder.append(
                    String.format("Successfully imported city %s - %d%n",
                            city.getCityName(), city.getPopulation()));


        }

        return stringBuilder.toString().trim();

    }
}
