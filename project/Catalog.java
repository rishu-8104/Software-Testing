package project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog {
    private List<Book> books;

    // Constructor
    public Catalog() {
        this.books = new ArrayList<>();
    }

    // Adds a new book to the catalog
    public void addBook(Book book) {
        books.add(book);
    }

    // Removes a book from the catalog by ISBN
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getISBN().equals(isbn));
    }

    // Finds books by title
    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    // Finds books by author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Returns a list of all available books
    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
}
