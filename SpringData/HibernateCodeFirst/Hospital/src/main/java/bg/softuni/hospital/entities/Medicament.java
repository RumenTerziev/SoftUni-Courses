package bg.softuni.hospital.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medicaments")
@Getter
@Setter
public class Medicament extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(targetEntity = Patient.class, mappedBy = "medicaments")
    private Set<Patient> patients;
}
