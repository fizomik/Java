package sample;
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String year;

    public Book(String isbn, String title, String author, String year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
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
    public String getYear() {
        return year;
    }
}