package bg.rumen.patterns.factory;

public class Main {
    public static void main(String[] args) {


        BaseBook gotBook = new BookCreator().createBook();

        System.out.println(gotBook);


    }
}
