package bg.softuni.hospital.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name ="diagnoses")
@Getter
@Setter
public class Diagnose extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String comments;


    @ManyToMany(targetEntity = Patient.class, mappedBy = "diagnoses")
    private Set<Patient> patients;
}
