package bg.softuni.sales;

import bg.softuni.sales.utils.EntityManagerCreator;

import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
