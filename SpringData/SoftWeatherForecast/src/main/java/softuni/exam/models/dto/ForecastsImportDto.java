package softuni.exam.models.dto;

import lombok.Getter;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@Getter
@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastsImportDto implements Serializable {

    @XmlElement(name = "forecast")
    private List<ForecastImportDto> forecasts;

}
