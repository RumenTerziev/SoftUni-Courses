package jarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> stackJar = new Jar<>();

        stackJar.add(13);

        int removed = stackJar.remove();

        System.out.println(removed);
    }
}
