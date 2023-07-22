package bg.rumen.patterns.singleton;

import java.util.*;

public class DataSource {

    private static DataSource instance;
    private final List<String> data;

    private DataSource() {
        this.data = new ArrayList<>();
        this.addInitialDataToResource();
    }


    public static  DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }


    public void addData(String newData) {
        this.data.add(newData);
    }


    public void removeFirst(String removedData) {
        Optional<String> first = this.data.stream().filter(s -> s.equals(removedData)).findFirst();
        if (first.isPresent()) {
            this.data.remove(first.get());
        } else {
            throw new NoSuchElementException("Element was not found!");
        }
    }

    public void removeAll(String removedData) {
        List<String> matched = this.data.stream().filter(s -> s.equals(removedData)).toList();
        if (matched.isEmpty()) {
            throw new NoSuchElementException("Element was not found!");
        } else {
            this.data.removeAll(matched);
        }
    }


    public Integer getSize() {
        return this.data.size();
    }


    public String get(Integer index) {
        return this.data.get(index);
    }


    public boolean containsElement(String element) {
        return this.data.contains(element);
    }


    public List<String> getData() {
        return Collections.unmodifiableList(this.data);
    }

    private void addInitialDataToResource() {
        this.data.add("Why");
        this.data.add("am");
        this.data.add("I");
        this.data.add("Doing");
        this.data.add("This");
        this.data.add("Pretty");
        this.data.add("Cool");
        this.data.add("Text");
        this.data.add("Message");
        this.data.add("Here");
    }
}
