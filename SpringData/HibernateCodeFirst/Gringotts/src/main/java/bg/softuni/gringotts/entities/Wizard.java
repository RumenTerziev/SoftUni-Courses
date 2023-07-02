package bg.softuni.gringotts.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wizards")
@Getter
@Setter
public class Wizard extends BaseEntity {


    @Column(name = "first_name", length = 50)
    private String firstName;


    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;


    @Column(columnDefinition = "TEXT", length = 1000)
    private String notes;

    @Column(nullable = false)
    private Integer age;


    @OneToOne
    @JoinColumn(name = "magic_wand_id")
    private MagicWand magicWand;


    @OneToMany(mappedBy = "wizard", targetEntity = Deposit.class)
    private List<Deposit> depositList;

}
