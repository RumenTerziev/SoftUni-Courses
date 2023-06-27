package utils;

import tasks.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private final Reader reader;
    private final Logger logger;

    public TaskManager(Reader reader, Logger logger) {
        this.reader = reader;
        this.logger = logger;
    }


    public void solve() throws InvocationTargetException, IllegalAccessException {
        this.logger.log("Please enter the number of the task you want to check out!" +
                "From 2 to 13");

        int numberOfTask = Integer.parseInt(this.reader.readLine());

        if (numberOfTask < 2 || numberOfTask > 13) {
            this.logger.log("No such task with the searched number!");
            return;
        }

        Map<Integer, Class<?>> taskMap = getTaskMap();
        Method[] declaredMethods = taskMap.get(numberOfTask).getDeclaredMethods();

        declaredMethods[0].setAccessible(true);
        String result = declaredMethods[0].invoke(taskMap.get(numberOfTask)).toString();
        this.logger.log(result);

    }

    private Map<Integer, Class<?>> getTaskMap() {

        Map<Integer, Class<?>> resultMap = new HashMap<>();
        resultMap.put(2, ChangeCasing02.class);
        resultMap.put(3, ContainsEmployee03.class);
        resultMap.put(4, EmployeesSalaries04.class);
        resultMap.put(5, EmployeesFromDepartment05.class);
        resultMap.put(6, UpdateEmployeeAddress06.class);
        resultMap.put(7, AddressesWithEmployeeCount07.class);
        resultMap.put(8, EmployeesWithProject08.class);
        resultMap.put(9, LatestTenProjects09.class);
        resultMap.put(10, IncreaseSalaries10.class);
        resultMap.put(11, ChangeCasing02.class);
        resultMap.put(12, ChangeCasing02.class);
        resultMap.put(13, ChangeCasing02.class);

        return resultMap;
    }

}
