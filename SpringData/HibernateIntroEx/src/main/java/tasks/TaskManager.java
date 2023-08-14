package tasks;

import utils.io.log.Logger;
import utils.io.log.LoggerManager;
import utils.io.read.Reader;
import utils.io.read.ReaderManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    private static final Map<Integer, Class<?>> CLASS_TASK_MAP = getClassTaskMap();
    private static final Map<Integer, Task> INTERFACE_TASK_MAP = getInterfaceTaskMap();
    private static final Map<Integer, Method> METHOD_TASK_MAP = getMethodTaskMap();

    public static void solve() throws InvocationTargetException, IllegalAccessException, InstantiationException {

        Reader reader = ReaderManager.getReader();
        Logger logger = LoggerManager.getLogger();

        logger.log("Please enter the number of the task you want to check out!" + "From 2 to 13");

        String input = reader.readLine();

        int numberOfTask = Integer.parseInt(input.trim());

        if (numberOfTask < 2 || numberOfTask > 13) {
            logger.log("No such task with the searched number!");
            return;
        }


        Method[] declaredMethods = CLASS_TASK_MAP.get(numberOfTask).getDeclaredMethods();
        Method solve = Arrays.stream(declaredMethods)
                .filter(m -> m.getName().equals("solve"))
                .findFirst()
                .orElse(null);

        if (solve == null) {
            logger.log("Failed to find the correct method!");
            return;
        }

        solve.setAccessible(true);
        solve.invoke(CLASS_TASK_MAP.get(numberOfTask));

//        Class<?> declaringClass = METHOD_TASK_MAP.get(numberOfTask).getDeclaringClass();
//        Object o = declaringClass.getDeclaredConstructors()[0].newInstance();
//        METHOD_TASK_MAP.get(numberOfTask).setAccessible(true);
//        METHOD_TASK_MAP.get(numberOfTask).invoke(o);
    }


    private static Map<Integer, Class<?>> getClassTaskMap() {

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


    private static Map<Integer, Task> getInterfaceTaskMap() {

        Map<Integer, Task> resultMap = new HashMap<>();
//        resultMap.put(2, new ChangeCasing02());
        resultMap.put(3, new ContainsEmployee03());
        resultMap.put(4, new EmployeesSalaries04());
        resultMap.put(5, new EmployeesFromDepartment05());
        resultMap.put(6, new UpdateEmployeeAddress06());
        resultMap.put(7, new AddressesWithEmployeeCount07());
        resultMap.put(8, new EmployeesWithProject08());
        resultMap.put(9, new LatestTenProjects09());
        resultMap.put(10, new IncreaseSalaries10());
        resultMap.put(11, new EmployeesByFirstName11());
        resultMap.put(12, new EmployeesMaximumSalaries12());
        resultMap.put(13, new RemoveTowns13());

        return resultMap;
    }


    private static Map<Integer, Method> getMethodTaskMap() {
        String methodName = "solve";
        Map<Integer, Method> resultMap = new HashMap<>();
        try {

            resultMap.put(2, ChangeCasing02.class.getDeclaredMethod(methodName));
            resultMap.put(3, ContainsEmployee03.class.getDeclaredMethod(methodName));
            resultMap.put(4, EmployeesSalaries04.class.getDeclaredMethod(methodName));
            resultMap.put(5, EmployeesFromDepartment05.class.getDeclaredMethod(methodName));
            resultMap.put(6, UpdateEmployeeAddress06.class.getDeclaredMethod(methodName));
            resultMap.put(7, AddressesWithEmployeeCount07.class.getDeclaredMethod(methodName));
            resultMap.put(8, EmployeesWithProject08.class.getDeclaredMethod(methodName));
            resultMap.put(9, LatestTenProjects09.class.getDeclaredMethod(methodName));
            resultMap.put(10, IncreaseSalaries10.class.getDeclaredMethod(methodName));
            resultMap.put(11, EmployeesByFirstName11.class.getDeclaredMethod(methodName));
            resultMap.put(12, EmployeesMaximumSalaries12.class.getDeclaredMethod(methodName));
            resultMap.put(13, RemoveTowns13.class.getDeclaredMethod(methodName));
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }


        return resultMap;
    }

}
