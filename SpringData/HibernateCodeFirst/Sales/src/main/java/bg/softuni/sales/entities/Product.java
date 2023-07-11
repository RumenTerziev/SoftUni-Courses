package bg.softuni.sales.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity{

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column
    private Double quantity;

    @Column
    private BigDecimal price;


    @OneToMany(mappedBy = "product", targetEntity = Sale.class)
    private Set<Sale> sales;

}
