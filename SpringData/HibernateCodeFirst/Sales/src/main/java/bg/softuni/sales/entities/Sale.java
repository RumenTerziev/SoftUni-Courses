package bg.softuni.sales.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @ManyToOne(targetEntity = Product.class)
    private Product product;


    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;


    @ManyToOne(targetEntity = StoreLocation.class)
    @JoinColumn(name = "store_location_id", referencedColumnName = "id")
    private StoreLocation storeLocation;

    @Column
    private Date date;
}
