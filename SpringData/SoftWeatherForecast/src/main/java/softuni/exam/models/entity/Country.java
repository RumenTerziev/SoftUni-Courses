package softuni.exam.models.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country extends BaseEntity {

    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;


    @Column(nullable = false)
    private String currency;


    @OneToMany(targetEntity = City.class, mappedBy = "country")
    private Set<City> cities;


}
