package bg.rumen.miniorm;

import bg.rumen.miniorm.jdbc.ConnectionManager;
import bg.rumen.miniorm.entities.User;
import bg.rumen.miniorm.manager.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {
            doSolve();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private static void doSolve() throws SQLException,
            IllegalAccessException,
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException {

        Connection connection = ConnectionManager.getConnection();
        EntityManager<User> userManager = new EntityManager<>(connection);

        User user = new User();

        user.setName("Pesho");
        user.setRegistration(LocalDate.of(2021, 6, 20));

        userManager.persist(user);

        User found = userManager.findFirst(User.class, "YEAR(registration_date) > 2020 AND user_name = 'Pesho'");


        System.out.println(found.getId());
        System.out.println(found.getName());
        System.out.println(found.getRegistration());

    }
}
