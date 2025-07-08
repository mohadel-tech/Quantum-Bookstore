
abstract class book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int yearPublished;
    protected double price;

    public book(String isbn, String title, String author, int yearPublished, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public double getPrice() {
        return price;
    }

    public abstract String getBookType();
    public abstract boolean isPurchased();
    public abstract double processPurchase(int quantity, String email, String address) throws Exception;

    @Override
    public String toString() {
        return String.format("%s by %s (%d) - ISBN: %s", title, author, yearPublished, isbn);
    }
}
