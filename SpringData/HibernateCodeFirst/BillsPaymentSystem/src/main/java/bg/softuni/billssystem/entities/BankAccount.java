package bg.softuni.billssystem.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetails {

    @Column(name = "bank_name", nullable = false, length = 120)
    private String bankName;

    @Column(name = "SWIFT_code", nullable = false, length = 20)
    private String SWIFTCode;

}
