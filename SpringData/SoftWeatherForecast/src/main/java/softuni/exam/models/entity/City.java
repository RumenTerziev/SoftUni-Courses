package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cities")
@Getter
@Setter
public class City extends BaseEntity {

    @Column(name = "city_name", nullable = false, unique = true)
    private String cityName;


    @Column(columnDefinition = "TEXT")
    private String description;


    @Column(nullable = false)
    private Integer population;


    @ManyToOne(optional = false, targetEntity = Country.class)
    private Country country;


    @OneToMany(targetEntity = Forecast.class, mappedBy = "city")
    private Set<Forecast> forecasts;
}
