package bg.softuni.billssystem.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BillingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false, length = 120)
    private String number;

    @ManyToOne(targetEntity = User.class, optional = false)
    private User owner;

}
