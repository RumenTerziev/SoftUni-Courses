package bg.rumen.hibernateintro.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "students")
public class Student {
    @Id
    private long id;
    @Column(name = "first_name")
    private String name;


    public Student() {
    }

    public Student(String name) {
        this();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
