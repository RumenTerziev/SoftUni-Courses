package bg.rumen.patterns.factory;

public class Main {
    public static void main(String[] args) {
        Book gotBook = BookFactory.getGameOfThronesBook();

        Book harryBook = BookFactory.getHarryPotterBook();

        System.out.println(gotBook);

        System.out.println();

        System.out.println(harryBook);
    }
}
