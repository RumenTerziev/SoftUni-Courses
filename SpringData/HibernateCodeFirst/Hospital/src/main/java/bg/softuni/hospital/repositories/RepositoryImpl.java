package bg.softuni.hospital.repositories;

import bg.softuni.hospital.utils.EntityManagerCreator;

import javax.persistence.EntityManager;

public class RepositoryImpl<E> implements Repository<E> {

    private static final EntityManager ENTITY_MANAGER = EntityManagerCreator.getEntityManager();

    @Override
    public void save(E entity) {

        ENTITY_MANAGER.getTransaction().begin();

        ENTITY_MANAGER.persist(entity);

        ENTITY_MANAGER.getTransaction().commit();

    }

    @Override
    public void remove(E entity) {

        ENTITY_MANAGER.getTransaction().begin();

        ENTITY_MANAGER.remove(entity);

        ENTITY_MANAGER.getTransaction().commit();

    }


    @Override
    public void closeConnection() {
        ENTITY_MANAGER.close();
    }
}
