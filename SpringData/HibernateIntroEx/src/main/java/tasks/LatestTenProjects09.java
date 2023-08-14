package tasks;

import entities.Project;
import utils.EntityManagerCreator;
import utils.io.log.LoggerManager;
import utils.io.log.Logger;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;

public class LatestTenProjects09 implements Task {

    public void solve() {

        Logger logger = LoggerManager.getLogger();

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        List<Project> resultList = entityManager.createQuery(
                        "SELECT p FROM Project p ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();


        StringBuilder sb = new StringBuilder();
        resultList.stream().sorted(Comparator.comparing(Project::getName))
                .forEach(p -> sb.append(
                        String.format("Project name: %s%n" +
                                "   Project Description: %s%n" +
                                "   Project Start Date: %s%n" +
                                "   Project End Date: %s%n%n",
                                p.getName(),
                                p.getDescription(),
                                p.getStartDate(),
                                p.getEndDate())));

        entityManager.getTransaction().commit();

        logger.log(sb.toString().trim());
    }
}
