package bg.rumen.patterns.factory;

public class BookCreator extends Creator {

    @Override
    public BaseBook createBook() {
        return new Book();
    }
}
