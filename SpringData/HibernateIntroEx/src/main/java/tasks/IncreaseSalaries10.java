package tasks;

import entities.Employee;
import utils.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class IncreaseSalaries10 {
    public static String solve() {
        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        List<String> searchedDeps = List.of("Engineering", "Tool Design", "Marketing", "Information Services");
        BigDecimal increasingIndex = BigDecimal.valueOf(0.12);

        List<Employee> resultList = entityManager.createQuery(
                        "SELECT e FROM Employee e WHERE e.department.name IN :searchedDeps", Employee.class)
                .setParameter("searchedDeps", searchedDeps)
                .getResultList();

        resultList.forEach(e -> e.setSalary(e.getSalary().add(e.getSalary().multiply(increasingIndex))));

        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.0000");

        resultList.forEach(e -> sb.append(String.format("%s %s ($%s)%n", e.getFirstName(), e.getLastName(), df.format(e.getSalary()))));

        entityManager.getTransaction().commit();

        return sb.toString().trim();
    }
}
