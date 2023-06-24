package bg.rumen.miniorm.entities;

import bg.rumen.miniorm.annotations.Column;
import bg.rumen.miniorm.annotations.Entity;
import bg.rumen.miniorm.annotations.Id;

import java.time.LocalDate;

@Entity(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "registration_date")
    private LocalDate registration;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getRegistration() {
        return this.registration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }
}
