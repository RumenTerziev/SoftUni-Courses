package bg.softuni.gringotts;

import bg.softuni.gringotts.entities.Deposit;
import bg.softuni.gringotts.entities.MagicWand;
import bg.softuni.gringotts.entities.Wizard;
import bg.softuni.gringotts.utils.EntityManagerCreator;
import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        MagicWand magicWand = new MagicWand();
        magicWand.setCreator("Loshkov");
        magicWand.setSize(20);

        entityManager.persist(magicWand);


        Wizard wizard = new Wizard();
        wizard.setFirstName("Pesho");
        wizard.setLastName("Petrov");
        wizard.setAge(20);
        wizard.setMagicWand(magicWand);

        entityManager.persist(wizard);

        Deposit deposit = new Deposit();
        deposit.setDepositGroup("Cool group");
        deposit.setDepositAmount(BigDecimal.valueOf(50));
        deposit.setWizard(wizard);
        entityManager.persist(deposit);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
