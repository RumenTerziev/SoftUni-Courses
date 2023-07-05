package utils;

import tasks.*;
import utils.interfaces.Logger;
import utils.interfaces.Reader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private static final Map<Integer, Class<?>> TASK_MAP = getTaskMap();

    public static void solve() throws InvocationTargetException, IllegalAccessException {

        Reader reader = ReaderManager.getReader();
        Logger logger = LoggerManager.getLogger();

        logger.log("Please enter the number of the task you want to check out!" +
                "From 2 to 13");

        int numberOfTask = Integer.parseInt(reader.readLine());

        if (numberOfTask < 2 || numberOfTask > 13) {
            logger.log("No such task with the searched number!");
            return;
        }

        Method[] declaredMethods = TASK_MAP.get(numberOfTask).getDeclaredMethods();
        Method solve = declaredMethods[0];

        solve.setAccessible(true);

        solve.invoke(TASK_MAP.get(numberOfTask));

    }

    private static Map<Integer, Class<?>> getTaskMap() {

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
        resultMap.put(11, EmployeesByFirstName11.class);
        resultMap.put(12, EmployeesMaximumSalaries12.class);
        resultMap.put(13, RemoveTowns13.class);

        return resultMap;
    }


//    private static Map<Integer, String> getPrintMassages() {
//
//        Map<Integer, String> printMassages = new HashMap<>();
//
//        printMassages.put(3, "Please enter full name to search by!");
//        printMassages.put(6, "Please enter last name to update an employee address!");
//        printMassages.put(8, "Please enter id to search by!");
//        printMassages.put(11, "Please enter a pattern to search by for employee's first name!");
//        printMassages.put(13, "Please enter town name to remove from DB!");
//
//        return printMassages;
//    }


}
