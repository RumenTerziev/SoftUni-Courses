package bg.softuni.unisystem.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends Person {

    @Column(name = "average_grade")
    private Double averageGrade;

    @Column
    private Double attendance;

    @ManyToMany()
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Course> courses;

}
