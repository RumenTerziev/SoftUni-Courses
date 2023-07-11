package bg.softuni.unisystem;

import bg.softuni.unisystem.utils.EntityManagerCreator;

import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        entityManager.getTransaction().begin();


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
