package bg.softuni.sales.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "store_locations")
@Getter
@Setter
public class StoreLocation extends BaseEntity {

    @Column(name = "location_name", nullable = false)
    private String locationName;


    @OneToMany(mappedBy = "storeLocation", targetEntity = Sale.class)
    private Set<Sale> sales;

}
