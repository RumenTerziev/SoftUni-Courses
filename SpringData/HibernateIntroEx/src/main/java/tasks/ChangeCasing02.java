package tasks;

import entities.Town;
import utils.EntityManagerCreator;
import utils.LoggerManager;
import utils.interfaces.Logger;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeCasing02 {

    public static void solve() {

        Logger logger = LoggerManager.getLogger();

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

         logger.log(stringBuilder.toString().trim());
    }
}
