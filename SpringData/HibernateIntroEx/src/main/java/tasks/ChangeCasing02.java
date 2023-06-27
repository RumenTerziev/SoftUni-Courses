package tasks;

import entities.Town;
import utils.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeCasing02 {

    public static String solve() {

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();


        List<Town> towns = entityManager.createQuery("FROM Town WHERE CHAR_LENGTH(name) <= 5", Town.class)
                .getResultList();

        towns = towns.stream().peek(town -> town.setName(town.getName().toUpperCase())).collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();
        for (Town town : towns) {
            stringBuilder.append(town.getName())
                    .append(System.lineSeparator());
        }

        entityManager.getTransaction().commit();

        return stringBuilder.toString().trim();
    }
}
