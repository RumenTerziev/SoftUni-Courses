package bg.softuni.billssystem;

import bg.softuni.billssystem.entities.BankAccount;
import bg.softuni.billssystem.entities.BillingDetails;
import bg.softuni.billssystem.entities.CreditCard;
import bg.softuni.billssystem.entities.User;
import bg.softuni.billssystem.utils.EntityManagerCreator;

import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        entityManager.getTransaction().begin();

        User user = new User();
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setEmail("cool@asd.bg");
        user.setPassword("cool_password");

        entityManager.persist(user);

        BankAccount bankAccount = new BankAccount();
        bankAccount.setNumber("asd");
        bankAccount.setOwner(user);
        bankAccount.setNumber("cool number");
        bankAccount.setBankName("cool bank");
        bankAccount.setSWIFTCode("COOL code");


        entityManager.persist(bankAccount);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
