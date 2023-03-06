import java.util.function.Consumer;

public class SmartArray {

    private int[] data;

    private int size;

    public SmartArray() {
        this.size = 0;
        this.data = new int[4];
    }

    private void ensureIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
    }


    public void add(int element) {
        if (size == data.length) {
            data = grow();
        }

        data[size++] = element;
    }

    private int[] grow() {

        int newLength = data.length * 2;

        int[] newArray = new int[newLength];

        System.arraycopy(data, 0, newArray, 0, data.length);

        return data = newArray;
    }


    public int get(int index) {

        ensureIndex(index);

        return data[index];
    }


    public int remove(int index) {

        int removed = get(index);

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];

        }
        data[size - 1] = 0;
        size--;

        if (size == data.length / 4) {
            data = shrink();
        }
        return removed;
    }

    private int[] shrink() {

        int newLength = data.length / 2;

        int[] newArray = new int[newLength];

        if (size >= 0) {
            System.arraycopy(data, 0, newArray, 0, size);
        }
        return data = newArray;
    }

    public boolean contains(int element) {

        for (int i = 0; i < size; i++) {
            int currentElement = data[i];
            if (currentElement == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {

        ensureIndex(index);

        int lastElement = data[size - 1];

        for (int i = size - 1; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        add(lastElement);
    }

    public void forEach(Consumer<Integer> consumer) {

        for (int index = 0; index < size; index++) {
            consumer.accept(data[index]);
        }

    }
}
