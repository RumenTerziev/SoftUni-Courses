package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {

    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {

            return data.removeIf(animal -> animal.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {

     return data.stream().filter(animal -> animal.getName().equals(name)).findFirst().orElse(null);
    }

    public Animal getOldestAnimal() {

        return data.stream().max(Comparator.comparingInt(Animal::getAge)).orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("The shelter has the following animals:").append(System.lineSeparator());

        if (!data.isEmpty()) {
            for (Animal animal : data) {
                stringBuilder.append(String.format("%s %s", animal.getName(), animal.getCaretaker())).append(System.lineSeparator());
            }
        } else {
            stringBuilder.append("null");
        }
        return stringBuilder.toString().trim();
    }
}
