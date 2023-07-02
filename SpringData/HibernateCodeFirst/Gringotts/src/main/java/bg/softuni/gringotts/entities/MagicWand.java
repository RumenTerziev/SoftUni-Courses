package bg.softuni.gringotts.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "magic_wands")
@Getter
@Setter
public class MagicWand extends BaseEntity {

    @Column(name = "magic_wand_creator", nullable = false, length = 100)
    private String creator;


    @Column(name = "magic_wand_size")
    private Integer size;


}
