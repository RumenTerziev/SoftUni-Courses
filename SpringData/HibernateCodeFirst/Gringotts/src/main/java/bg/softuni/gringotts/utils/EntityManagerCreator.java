package bg.softuni.gringotts.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {

    public static EntityManager getEntityManager() {
      EntityManagerFactory entityManagerFactory =
              Persistence.createEntityManagerFactory("gringotts");

        return entityManagerFactory.createEntityManager();
    }
}
