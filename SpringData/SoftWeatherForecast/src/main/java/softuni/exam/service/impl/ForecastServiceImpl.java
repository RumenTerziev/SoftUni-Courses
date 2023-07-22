package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.constants.DayOfWeek;
import softuni.exam.models.dto.ForecastExportDto;
import softuni.exam.models.dto.ForecastImportDto;
import softuni.exam.models.dto.ForecastsImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.io.read.FileReader;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static softuni.exam.models.constants.JsonPath.FORECAST_FILE_PATH;

@Service
public class ForecastServiceImpl implements ForecastService {


    @Autowired
    @Qualifier("forecastUnmarshaller")
    private Unmarshaller unmarshaller;

    @Autowired
    private FileReader fileReader;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    @Qualifier("modelMapper")
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("forecastExportDtoMapper")
    private ModelMapper forecastExportDtoMapper;


    @Autowired
    private ForecastRepository forecastRepository;


    @Override
    public boolean areImported() {

        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {

        return this.fileReader.readAllData(FORECAST_FILE_PATH);
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {


        if (areImported()) {
            return "";
        }


        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(Objects.requireNonNull
                        (this.getClass().getResourceAsStream(FORECAST_FILE_PATH))));

        ForecastsImportDto forecastsDto = (ForecastsImportDto) this.unmarshaller.unmarshal(bufferedReader);
        bufferedReader.close();


        StringBuilder stringBuilder = new StringBuilder();
        for (ForecastImportDto forecastImportDto : forecastsDto.getForecasts()) {

            if (!forecastImportDto.isValid()) {
                stringBuilder.append("Invalid forecast")
                        .append(System.lineSeparator());
                continue;
            }


            Optional<City> optionalCity = this.cityRepository.findFirstById(forecastImportDto.getCityId());

            if (optionalCity.isEmpty()) {
                stringBuilder.append("Invalid forecast")
                        .append(System.lineSeparator());
                continue;
            }

            Optional<Forecast> optionalForecast = this.forecastRepository.
                    findFirstByCityAndDayOfWeek(optionalCity.get(), DayOfWeek.valueOf(forecastImportDto.getDayOfWeek()));

            if (optionalForecast.isPresent()) {
                stringBuilder.append("Invalid forecast")
                        .append(System.lineSeparator());
                continue;
            }


            Forecast forecast = this.modelMapper.map(forecastImportDto, Forecast.class);
            forecast.setDayOfWeek(DayOfWeek.valueOf(forecastImportDto.getDayOfWeek()));
            forecast.setCity(optionalCity.get());

            forecast.setSunrise(getLocalTime(forecastImportDto.getSunrise()));

            forecast.setSunset(getLocalTime(forecastImportDto.getSunset()));

            this.forecastRepository.save(forecast);
            stringBuilder.append(
                    String.format("Successfully import forecast %s - %.2f%n",
                            forecast.getDayOfWeek().name(), forecast.getMaxTemperature()));

        }

        return stringBuilder.toString().trim();
    }

    private static LocalTime getLocalTime(String timeAsString) {

        String[] timeParts = timeAsString.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[0]);
        int seconds = Integer.parseInt(timeParts[0]);
        return LocalTime.of(hours, minutes, seconds);
    }

    @Override
    public String exportForecasts() {

        List<Forecast> forecasts = this.forecastRepository
                .findAllByDayOfWeekLikeAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek.SUNDAY, 150000);

        List<ForecastExportDto> forecastExportDtos =
                forecasts.stream().map(f -> this.forecastExportDtoMapper.map(f, ForecastExportDto.class)).toList();

        StringBuilder stringBuilder = new StringBuilder();
        forecastExportDtos.forEach(f -> stringBuilder.append(f.toString()).append(System.lineSeparator()));

        return stringBuilder.toString().trim();
    }
}
