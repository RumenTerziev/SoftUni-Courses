package bg.rumen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resource {
    private final List<String> strings;
    private static Resource instance;

    private Resource() {
        this.strings = new ArrayList<>();
        this.addInitialDataToResource();
    }


    public static synchronized Resource getInstance() {
        if (instance == null) {
            instance = new Resource();
        }
        return instance;
    }

    public Integer getSize() {
        return instance.getStrings().size();
    }


    public List<String> getStrings() {
        return Collections.unmodifiableList(this.strings);
    }

    public void addResources(String string) {
        this.strings.add(string);
    }

    private void addInitialDataToResource() {
        this.strings.add("Why");
        this.strings.add("am");
        this.strings.add("I");
        this.strings.add("Doing");
        this.strings.add("This");
        this.strings.add("Pretty");
        this.strings.add("Cool");
        this.strings.add("Text");
        this.strings.add("Message");
        this.strings.add("Here");
    }
}
