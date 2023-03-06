package genericArrayCreator;


import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {


    public static <T> T[] create(int length, T item) {

        T[] array = (T[]) Array.newInstance(item.getClass(), length);
        Arrays.fill(array, item);

        return (T[]) array;
    }
    public static <T> T[] create(Class<T> clazz, int length, T defaultValue) {

       T[] array = (T[]) Array.newInstance(clazz, length);

        Arrays.fill(array, defaultValue);

        return array;
    }

}
