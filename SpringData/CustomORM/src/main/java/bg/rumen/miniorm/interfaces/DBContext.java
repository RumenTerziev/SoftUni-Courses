package bg.rumen.miniorm.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DBContext<T> {

    boolean persist(T entity) throws IllegalAccessException, SQLException;

    Iterable<T> find(Class<T> table) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    Iterable<T> find(Class<T> table, String where) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    T findFirst(Class<T> table) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    T findFirst(Class<T> table, String where) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
