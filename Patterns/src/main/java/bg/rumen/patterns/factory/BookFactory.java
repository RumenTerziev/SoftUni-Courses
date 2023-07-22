package bg.rumen.patterns.factory;

import static bg.rumen.patterns.factory.Constants.*;

public class BookFactory {

    public static Book getGameOfThronesBook() {
        Book book = new Book();
        book.setTitle(GOT_TITLE);
        book.setAuthor(GOT_AUTHOR);
        book.setPrice(GOT_PRICE);
        book.setPages(GOT_PAGES);
        return book;
    }

    public static Book getHarryPotterBook() {
        Book book = new Book();
        book.setTitle(HARRY_TITLE);
        book.setAuthor(HARRY_AUTHOR);
        book.setPrice(HARRY_PRICE);
        book.setPages(HARRY_PAGES);
        return book;
    }
}
