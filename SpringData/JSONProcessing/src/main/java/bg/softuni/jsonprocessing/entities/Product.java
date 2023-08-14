package bg.softuni.jsonprocessing.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column
    private String name;

    @Column(scale = 2, precision = 19)
    private BigDecimal price;

    @ManyToOne
    private User buyer;

    @ManyToOne(optional = false)
    private User seller;

    @ManyToMany(targetEntity = Category.class)
    @JoinTable(name = "products_categories", joinColumns =
    @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Category> categories;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public User getBuyer() {
        return buyer;
    }

    public User getSeller() {
        return seller;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
