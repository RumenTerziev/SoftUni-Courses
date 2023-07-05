package tasks;

import entities.Department;
import utils.EntityManagerCreator;
import utils.LoggerManager;
import utils.interfaces.Logger;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class EmployeesMaximumSalaries12 {

    public static void solve() {

        Logger logger = LoggerManager.getLogger();

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        List<Department> departments = entityManager.createQuery("SELECT d FROM Department d", Department.class)
                .getResultList();


        Map<String, BigDecimal> departmentsMap = new LinkedHashMap<>();

        departments.forEach(d -> departmentsMap.put(d.getName(),
                BigDecimal.valueOf(
                        d.getEmployees().stream()
                                .mapToDouble(e -> e.getSalary().doubleValue())
                                .max().orElse(0.0))));

        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");

        departmentsMap.entrySet()
                .stream()
                .filter(e -> e.getValue().doubleValue() != 0.0
                        && e.getValue().doubleValue() < 30000
                        || e.getValue().doubleValue() > 70000)
                .forEach(e -> sb.append(String.format("%s %s%n",
                        e.getKey(),
                        df.format(e.getValue()))));

        entityManager.getTransaction().commit();
        logger.log(sb.toString().trim());
    }
}
