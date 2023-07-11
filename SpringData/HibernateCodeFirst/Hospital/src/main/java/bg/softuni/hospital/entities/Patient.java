package bg.softuni.hospital.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient extends BaseEntity {


    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String address;

    @Column
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;


    @Column(columnDefinition = "BLOB")
    private String picture;


    @Column(columnDefinition = "TINYINT", nullable = false)
    private boolean hasInsurance;

    @OneToMany(targetEntity = Visitation.class, mappedBy = "patient")
    private Set<Visitation> visitations;


    @ManyToMany(targetEntity = Medicament.class)
    @JoinTable(name = "patients_medicaments",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"))

    private Set<Medicament> medicaments;

    @ManyToMany(targetEntity = Diagnose.class)
    @JoinTable(name = "patients_diagnoses",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id"))
    private Set<Diagnose> diagnoses;
}
