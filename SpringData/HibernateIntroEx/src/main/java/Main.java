import utils.TaskManager;

public class Main {

    public static void main(String[] args) {

        try {
            TaskManager.solve();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
