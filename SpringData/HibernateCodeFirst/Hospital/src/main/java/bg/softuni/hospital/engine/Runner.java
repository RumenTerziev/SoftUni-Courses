package bg.softuni.hospital.engine;

import bg.softuni.hospital.messages.Messages;
import bg.softuni.hospital.utils.EntityManagerCreator;
import bg.softuni.hospital.utils.InvocationManager;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static bg.softuni.hospital.messages.Messages.ENTER_DATE_OF_BIRTH;
import static bg.softuni.hospital.messages.Messages.INITIAL_MESSAGE;

public class Runner {

    private static final Map<String, List<String>> MESSAGES_MAP = Messages.getMessagesMap();
    private static final Map<String, Class<?>> ENTITY_MAP = InvocationManager.getEntityMap();
    private static final EntityManager ENTITY_MANAGER = EntityManagerCreator.getEntityManager();

    public static void run() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Scanner scanner = new Scanner(System.in);


        System.out.println(INITIAL_MESSAGE);
        String command = scanner.nextLine().trim();

        while (!command.equals("End")) {

            if (command.equals("Skip")) {
                System.out.println(INITIAL_MESSAGE);
                continue;
            }

            String type = "";
            if (ENTITY_MAP.containsKey(command)) {
                type = command;
            }

            Object object = ENTITY_MAP.get(type).getDeclaredConstructor().newInstance();


            Method[] declaredMethods = new Method[0];
            if (!type.equals("")) {

                declaredMethods = ENTITY_MAP.get(type).getDeclaredMethods();
            }

            List<String> messages = MESSAGES_MAP.get(command);

            List<Method> setters = Arrays.stream(declaredMethods)
                    .filter(m -> m.getName().contains("set")).toList();


            for (int index = 0; index < messages.size(); index++) {
                String message = messages.get(index);
                System.out.println(message);
                command = scanner.nextLine().trim();

                if (!command.equals("Skip")) {


                    Method toInvoke = setters.get(index);

                    if (toInvoke == null) {
                        throw new IllegalArgumentException("Method was not found!");
                    }

                    toInvoke.setAccessible(true);

                    if (message.equals(ENTER_DATE_OF_BIRTH)) {

                        String[] tokens = command.split("\\s*-\\s*");
                        int year = Integer.parseInt(tokens[0]);
                        int month = Integer.parseInt(tokens[1]);
                        int day = Integer.parseInt(tokens[2]);

                        LocalDate localDate = LocalDate.of(year, month, day);
                        toInvoke.invoke(object, localDate);
                    } else {
                        toInvoke.invoke(object, command);
                    }

                } else {
                    continue;
                }

            }

            ENTITY_MANAGER.persist(object);
            command = scanner.nextLine();
        }

    }

}
