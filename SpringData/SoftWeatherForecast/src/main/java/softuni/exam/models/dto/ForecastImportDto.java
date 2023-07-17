package softuni.exam.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastImportDto implements Serializable {

    @XmlElement(name = "day_of_week")
    private String dayOfWeek;

    @XmlElement(name = "max_temperature")
    private Double maxTemperature;

    @XmlElement(name = "min_temperature")
    private Double minTemperature;

    @XmlElement(name = "sunrise")
    private String sunrise;

    @XmlElement(name = "sunset")
    private String sunset;


    @XmlElement(name = "city")
    private Integer cityId;


    public boolean isValid() {

        if (this.dayOfWeek.equals("NULL") || this.cityId == null) {
            return false;
        }


        if (this.maxTemperature == null || this.maxTemperature < -20 || this.maxTemperature > 60) {
            return false;
        }

        if (this.minTemperature == null || this.minTemperature < -40 || this.minTemperature > 50) {
            return false;
        }


        return true;

    }


}
