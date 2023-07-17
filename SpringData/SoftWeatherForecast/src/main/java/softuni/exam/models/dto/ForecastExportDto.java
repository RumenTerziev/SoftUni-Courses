package softuni.exam.models.dto;

import lombok.Setter;

@Setter
public class ForecastExportDto {

    private String cityName;

    private Double minTemperature;

    private Double maxTemperature;

    private String sunrise;

    private String sunset;


    @Override
    public String toString() {
        return String.format("City: %s:%n" +
                "-min temperature: %.2f%n" +
                "--max temperature: %.2f%n" +
                "---sunrise: %s%n" +
                "----sunset: %s", this.cityName, this.minTemperature, this.maxTemperature, this.sunrise, this.sunset);
    }

}
