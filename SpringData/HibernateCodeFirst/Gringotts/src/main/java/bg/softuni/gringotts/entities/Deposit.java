package bg.softuni.gringotts.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "deposits")
@Getter
@Setter
public class Deposit extends BaseEntity {


    @Column(name = "deposit_group", length = 20, nullable = false)
    private String depositGroup;


    @Column(name = "deposit_start_date")
    private LocalDate startDate;


    @Column(name = "deposit_amount", scale = 2, precision = 19)
    private BigDecimal depositAmount;


    @Column(name = "deposit_interest", scale  = 2, precision = 4)
    private BigDecimal depositInterest;


    @Column(name = "deposit_charge", scale = 2, precision = 19)
    private BigDecimal depositCharge;


    @Column(name = "deposit_expiration_date")
    private LocalDate depositExpirationDate;


    @Column(columnDefinition = "TINYINT", name ="is_deposit_expired")
    private boolean isDepositExpired;


    @ManyToOne(targetEntity = Wizard.class)
    @JoinColumn(name = "wizard_id", referencedColumnName = "id")
    private Wizard wizard;

}
