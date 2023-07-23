package bg.rumen.patterns.factory;

public class Book implements BaseBook{

    private String title;

    private String author;

    private Double price;

    private Integer pages;


    public Book() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }


    @Override
    public String toString() {
        return String.format("Title -> %s%nAuthor -> %s%nPrice -> $%.2f%nPages -> %d",
                this.title,
                this.author,
                this.price,
                this.pages);
    }

    @Override
    public void gettingOld() {
        this.price -= 10;
    }
}
