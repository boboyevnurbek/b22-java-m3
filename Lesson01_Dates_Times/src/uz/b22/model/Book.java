package uz.b22.model;

public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        return new Book(title);
    }
}
