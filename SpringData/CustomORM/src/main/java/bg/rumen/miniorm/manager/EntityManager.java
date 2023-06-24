package bg.rumen.miniorm.manager;

import bg.rumen.miniorm.annotations.Column;
import bg.rumen.miniorm.annotations.Entity;
import bg.rumen.miniorm.annotations.Id;
import bg.rumen.miniorm.interfaces.DBContext;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EntityManager<T> implements DBContext<T> {
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean persist(T entity) throws IllegalAccessException, SQLException {

        Field primaryKey = getId(entity.getClass());
        primaryKey.setAccessible(true);
        Object value = primaryKey.get(entity);

        if (value == null || (int) value <= 0) {
            return (doInsert(entity, primaryKey));
        }

        return doUpdate(entity, primaryKey);
    }


    @Override
    public Iterable<T> find(Class<T> table) throws SQLException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        List<T> resultList = new ArrayList<>();

        String tableName = getTableName(table);
        String query = String.format("SELECT * FROM %s;", tableName);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery(query);

        while (resultSet.next()) {
            T entity = table.getDeclaredConstructor().newInstance();
            fillEntity(table, resultSet, entity);
            resultList.add(entity);
        }

        return resultList;
    }

    @Override
    public Iterable<T> find(Class<T> table, String where) throws SQLException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        List<T> resultList = new ArrayList<>();

        String tableName = getTableName(table);
        String query = String.format("SELECT * FROM %s %s;", tableName, where != null ? " WHERE " + where : "");
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery(query);

        while (resultSet.next()) {
            T entity = table.getDeclaredConstructor().newInstance();
            fillEntity(table, resultSet, entity);
            resultList.add(entity);
        }

        return resultList;
    }

    @Override
    public T findFirst(Class<T> table) throws SQLException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        String tableName = getTableName(table);
        String query = String.format("SELECT * FROM %s LIMIT 1;", tableName);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery(query);
        T entity = table.getDeclaredConstructor().newInstance();
        resultSet.next();
        fillEntity(table, resultSet, entity);

        return entity;
    }

    @Override
    public T findFirst(Class<T> table, String where) throws SQLException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        String tableName = getTableName(table);

        String sqlQuery = String.format("SELECT * FROM %s %s LIMIT 1;", tableName,
                where != null ? " WHERE " + where : "");
        PreparedStatement statement = this.connection.prepareStatement(sqlQuery);

        ResultSet resultSet = statement.executeQuery(sqlQuery);
        T entity = table.getDeclaredConstructor().newInstance();
        resultSet.next();
        fillEntity(table, resultSet, entity);

        return entity;
    }

    private void fillEntity(Class<T> table, ResultSet resultSet, T entity) throws SQLException, IllegalAccessException {
        Field[] declaredFields = Arrays.stream(table.getDeclaredFields()).toArray(Field[]::new);

        for (Field field : declaredFields) {
            field.setAccessible(true);
            fillField(field, resultSet, entity);
        }

    }

    private void fillField(Field field, ResultSet resultSet, T entity) throws SQLException, IllegalAccessException {

        field.setAccessible(true);


        if (field.getType() == int.class || field.getType() == Integer.class) {
            field.set(entity, resultSet.getInt(field.getName()));
        } else if (field.getType() == LocalDate.class) {
            field.set(entity, resultSet.getDate(field.getAnnotation(Column.class).name()).toLocalDate());
        } else {
            field.set(entity, resultSet.getString(field.getAnnotation(Column.class).name()));
        }

    }

    private boolean doUpdate(T entity, Field primaryKey) throws IllegalAccessException, SQLException {

        String tableName = getTableName(entity.getClass());
        int searchedId = (int) primaryKey.get(entity);

        Map<String, String> fieldValues = new LinkedHashMap<>();
        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class) && !field.equals(primaryKey)) {
                field.setAccessible(true);
                fieldValues.put(field.getAnnotation(Column.class).name(), field.get(entity).toString());
            }
        }

        StringBuilder sb = new StringBuilder(String.format("UPDATE %s SET ", tableName));

        String toAppend = fieldValues.entrySet().stream().map(entry -> String.format("%s = '%s'", entry.getKey(), entry.getValue())).collect(Collectors.joining(", "));
        sb.append(toAppend);
        sb.append(" WHERE `id` = ?;");


        PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

        preparedStatement.setInt(1, searchedId);

        System.out.println(sb);
        return preparedStatement.executeUpdate() == 1;
    }

    private boolean doInsert(T entity, Field primaryKey) throws SQLException {


        String tableName = getTableName(entity.getClass());
        String fieldNames = getFieldNamesWithoutId(entity.getClass(), primaryKey);
        String fieldValues = getFieldValuesWithoutID(entity, primaryKey);

        String query = "INSERT INTO " + tableName + " (" + fieldNames + ") VALUES(" + fieldValues + ");";
        System.out.println(query);

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        return preparedStatement.executeUpdate() == 1;
    }

    private String getFieldValuesWithoutID(T entity, Field primaryKey) {

        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(f -> !f.getName().equals(primaryKey.getName()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> {
                    f.setAccessible(true);
                    try {
                        Object value = f.get(entity);
                        return String.format("'%s'", value.toString());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }

                })
                .collect(Collectors.joining(", "));
    }

    private String getFieldNamesWithoutId(Class<?> entityClass, Field primaryKey) {

        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> !f.getName().equals(primaryKey.getName()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> f.getAnnotation(Column.class).name())
                .collect(Collectors.joining(", "));

    }

    private String getTableName(Class<?> entityClass) {

        if (!entityClass.isAnnotationPresent(Entity.class)) {
            throw new RuntimeException("Unknown entity!");
        }

        return entityClass.getAnnotation(Entity.class).name();
    }

    private Field getId(Class<?> entity) {

        return Arrays.stream(entity.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have a primary key!"));
    }
}
