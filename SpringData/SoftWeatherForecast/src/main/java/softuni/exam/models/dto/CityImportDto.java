package softuni.exam.models.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class CityImportDto implements Serializable {

    private String cityName;

    private String description;

    private Integer population;

    private Integer country;


    public boolean isValid() {

        if (this.cityName.length() < 2 || this.cityName.length() > 60) {
            return false;
        }


        if (this.description.length() < 2) {
            return false;
        }


        if (this.population < 500) {
            return false;
        }

        return true;
    }


}
