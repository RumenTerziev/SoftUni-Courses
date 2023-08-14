package bg.softuni.jsonprocessing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(name = "name", length = 15)
    private String name;

    public String getName() {
        return name;
    }
}
