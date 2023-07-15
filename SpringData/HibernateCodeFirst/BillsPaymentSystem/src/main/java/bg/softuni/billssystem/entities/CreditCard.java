package bg.softuni.billssystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetails {

    @Column(name = "card_type", nullable = false, length = 60)
    private String cardType;

    @Column(name = "expiration_month", nullable = false, length = 20)
    private String expirationMonth;

    @Column(name = "expiration_year", nullable = false, length = 20)
    private String expirationYear;

}
