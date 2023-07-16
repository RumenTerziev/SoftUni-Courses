package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.models.dto.ForecastExportDto;
import softuni.exam.models.dto.ForecastsImportDto;
import softuni.exam.models.entity.Forecast;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean("modelMapper")
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


    @Bean("forecastExportDtoMapper")
    public ModelMapper getForecastExportDtoMapper() {
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<Forecast, ForecastExportDto> propertyMap = new PropertyMap<Forecast, ForecastExportDto>() {
            @Override
            protected void configure() {
                map().setCityName(source.getCity().getCityName());
            }
        };

        modelMapper.addMappings(propertyMap);
        return modelMapper;
    }

    @Bean
    public Gson getGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }


    @Bean("forecastUnmarshaller")
    public Unmarshaller getForecastUnmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ForecastsImportDto.class);
        return context.createUnmarshaller();
    }
}
