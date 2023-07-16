package softuni.exam.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class CountryImportDto implements Serializable {

    private String countryName;


    private String currency;


    public boolean isValid() {

        if (this.countryName.length() < 2 || this.countryName.length() > 60) {
            return false;
        }


        if (this.currency.length() < 2 || this.currency.length() > 60) {
            return false;
        }

        return true;
    }

}
