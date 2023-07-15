package bg.softuni.billssystem.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 60)
    private String lastName;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 150)
    private String password;

    @OneToMany(targetEntity = BillingDetails.class, mappedBy = "owner", cascade = {
            CascadeType.MERGE, CascadeType.DETACH
    })
    private Set<BillingDetails> billingDetails;

}
