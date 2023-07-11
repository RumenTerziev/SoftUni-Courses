package bg.softuni.hospital.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
@Getter
@Setter
public class Visitation extends BaseEntity {

    @Column(nullable = false)
    private LocalDate date;

    @Column(columnDefinition = "TEXT")
    private String comments;


    @ManyToOne(targetEntity = Patient.class)
    private Patient patient;


}
