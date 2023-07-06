package tasks;

import utils.io.log.LoggerManager;
import utils.io.read.ReaderManager;
import utils.io.log.Logger;
import utils.io.read.Reader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private static final Map<Integer, Class<?>> TASK_MAP = getTaskMap();

    public static void solve() throws InvocationTargetException, IllegalAccessException {

        Reader reader = ReaderManager.getReader();
        Logger logger = LoggerManager.getLogger();

        logger.log("Please enter the number of the task you want to check out!" +
                "From 2 to 13");

        String input = reader.readLine();

        int numberOfTask = Integer.parseInt(input.trim());

        if (numberOfTask < 2 || numberOfTask > 13) {
            logger.log("No such task with the searched number!");
            return;
        }

        Method[] declaredMethods = TASK_MAP.get(numberOfTask).getDeclaredMethods();
        Method solve = Arrays.stream(declaredMethods).filter(m -> m.getName().equals("solve")).findFirst().orElse(null);

        if (solve == null) {
            logger.log("Failed to find the correct method!");
            return;
        }

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

}
